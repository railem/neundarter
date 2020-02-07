package com.jedenger.neundarter.game.lobby;

import com.jedenger.neundarter.game.lobby.options.I_LobbyUpdateListener;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class S_LobbyManager
{
    private static S_LobbyManager instance;
    private Map<String,Lobby> lobbyMap;

    private List<I_LobbyListChangeListener> listListeners;
    private Map<I_LobbyUpdateListener, String> updateListeners;

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


    public List<Lobby> getLobbies()
    {
        return new ArrayList( lobbyMap.values() );
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

    public Lobby joinLobby( Player player, Lobby lobby )
    {
        lobby.join( player );

        lobbyMap.put( lobby.getId(), lobby );

        messageUpdateListeners( lobby );
        messageListListeners();

        return lobby;
    }

    public void leaveLobby( Player player, Lobby lobby )
    {
        lobby.leave( player );

        if( lobby.getPlayers().isEmpty() )
        {
            lobbyMap.remove( lobby.getId() );
        }
        messageUpdateListeners( lobby );
        messageListListeners();
    }

    public void updateLobby( Lobby updatedLobby )
    {
        lobbyMap.put( updatedLobby.getId(), updatedLobby );

        messageUpdateListeners( updatedLobby );
        messageListListeners();
    }

    public void registerListener( I_LobbyListChangeListener listener )
    {
        listListeners.add( listener );
    }

    public void registerListener( String lobbyId, I_LobbyUpdateListener listener )
    {
        updateListeners.put( listener, lobbyId );
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
        if( updateListeners.containsKey( listener ) )
        {
            updateListeners.remove( listener );
        }
    }

    private void messageListListeners()
    {
        listListeners.forEach( l -> l.lobbyListChanged() );
    }

    private void messageUpdateListeners( Lobby lobby )
    {
        updateListeners.entrySet().stream().filter( e -> e.getValue().equals( lobby.getId() ) )
        .collect( Collectors.toList() ).forEach( e -> e.getKey().lobbyUpdated( lobby ) );
    }

}
