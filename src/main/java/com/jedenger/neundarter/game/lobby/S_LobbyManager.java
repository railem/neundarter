package com.jedenger.neundarter.game.lobby;

import com.jedenger.neundarter.game.lobby.options.I_LobbyUpdateListener;

import java.util.*;

public class S_LobbyManager
{
    private static S_LobbyManager instance;
    private Map<String,Lobby> lobbyMap;

    private List<I_LobbyListChangeListener> listListeners;
    private Map<String, I_LobbyUpdateListener> updateListeners;

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
        this.listListeners = new ArrayList<>();
        this.updateListeners = new HashMap<>();
    }

    public Lobby createLobby( Player player )
    {
        Lobby lobby = new Lobby();
        lobby.setName( player.getName() + "'s Game!");
        lobby.join( player );

        lobbyMap.put( lobby.getId(), lobby );
        messageListListeners();

        return lobby;
    }

    public List<Lobby> getLobbies()
    {
        return new ArrayList( lobbyMap.values() );
    }

    public void updateLobby( Lobby updatedLobby )
    {
        lobbyMap.put( updatedLobby.getId(), updatedLobby );
        messageListListeners();
    }

    public void leaveLobby( Player player, Lobby lobby )
    {
        lobby.leave( player );

        if( lobby.getPlayers().isEmpty() )
        {
            lobbyMap.remove( lobby.getId() );
        }
        messageListListeners();
    }

    public void registerListener( I_LobbyListChangeListener listener )
    {
        listListeners.add( listener );
    }

    public void registerListener( String lobbyId, I_LobbyUpdateListener listener )
    {
        updateListeners.put( lobbyId, listener );
    }


    public void unregisterListener( I_LobbyListChangeListener listener )
    {
        if( listListeners.contains( listener ) )
        {
            listListeners.remove( listener );
        }
    }

    public void unregisterListener( I_LobbyUpdateListener listener )
    {
        if( updateListeners.containsValue( listener ) )
        {
            updateListeners.remove( updateListeners.entrySet().stream()
                    .filter( entry -> entry.equals(listener) ).map( Map.Entry::getKey ).findFirst().get() );
        }
    }

    private void messageListListeners()
    {
        listListeners.forEach( l -> l.lobbyListChanged() );
    }

    private void messageUpdateListeners()
    {
        //updateListeners.forEach( l -> l.lobbyUpdated( ) );
    }
}
