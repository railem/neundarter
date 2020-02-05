package com.jedenger.neundarter.game.lobby;

import java.util.*;

public class S_LobbyManager
{
    private static S_LobbyManager instance;
    private Map<String,Lobby> lobbyMap;
    private List<I_LobbyChangeListener> listeners;

    public static S_LobbyManager getInstance()
    {
        if( instance == null )
        {
            instance = new S_LobbyManager();
        }
        return instance;
    }


    public S_LobbyManager()
    {
        this.lobbyMap = new HashMap<>();
        this.listeners = new ArrayList<>();
    }

    public Lobby createLobby( Player player )
    {
        Lobby lobby = new Lobby();
        lobby.setName( player.getName() + "'s Game!");

        lobbyMap.put( lobby.getId(), lobby );
        messageListeners();

        return lobby;
    }

    public List<Lobby> getLobbies()
    {
        return new ArrayList( lobbyMap.values() );
    }

    public void updateLobby( Lobby updatedLobby )
    {
        lobbyMap.put( updatedLobby.getId(), updatedLobby );
        messageListeners();
    }

    public void closeLobby( Lobby lobby )
    {
        lobby.close();
        lobbyMap.remove( lobby.getId() );
        messageListeners();
    }

    public void registerListener( I_LobbyChangeListener listener )
    {
        listeners.add( listener );
    }

    private void messageListeners()
    {
        listeners.forEach( l -> l.lobbyListChanged() );
    }

    public void unregisterListener( I_LobbyChangeListener listener )
    {
        if( listeners.contains( listener ) )
        {
            listeners.remove( listener );
        }
    }
}
