package com.jedenger.neundarter.ui.lobby.list;

import com.jedenger.neundarter.game.lobby.I_LobbyListChangeListener;
import com.jedenger.neundarter.game.lobby.Lobby;
import com.jedenger.neundarter.game.lobby.Player;
import com.jedenger.neundarter.game.lobby.S_LobbyManager;
import com.jedenger.neundarter.ui.I_MainListener;
import com.vaadin.ui.VerticalLayout;

public class LobbyListPresenter implements I_LobbyListListener, I_LobbyListChangeListener
{
    private I_MainListener mainListener;
    private S_LobbyManager lobbyManager;
    private VerticalLayout layout;
    private Player player;

    private LobbyListUI lobbyListUI;

    public LobbyListPresenter( I_MainListener mainListener, VerticalLayout layout, Player player )
    {
        this.mainListener = mainListener;
        this.layout = layout;
        this.player = player;
        this.lobbyManager = S_LobbyManager.getInstance();

        this.lobbyListUI = new LobbyListUI( this, layout );

        lobbyListUI.setLobbyList( lobbyManager.getLobbies() );
        lobbyManager.registerListener( this );
    }


    @Override
    public void lobbyListChanged()
    {
        lobbyListUI.setLobbyList( lobbyManager.getLobbies() );
    }

    @Override
    public void showCreateLobbyUI() 
    {
        lobbyManager.unregisterListener( this );
        mainListener.showLobbyDetailsUI();
    }

    @Override
    public void joinLobby( Lobby lobby )
    {
        if( lobby.getPlayers().size() < lobby.getMaxPlayers() )
        {
            lobbyManager.unregisterListener( this );

            lobbyManager.joinLobby( player, lobby );
            mainListener.showLobbyDetailsUI( lobby );
        }
        else
        {
            //TODO show error ?
        }
    }
}
