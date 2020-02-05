package com.jedenger.neundarter.ui.lobby;

import com.jedenger.neundarter.game.lobby.I_LobbyChangeListener;
import com.jedenger.neundarter.game.lobby.Lobby;
import com.jedenger.neundarter.game.lobby.Player;
import com.jedenger.neundarter.game.lobby.S_LobbyManager;
import com.jedenger.neundarter.ui.I_MainListener;
import com.vaadin.ui.VerticalLayout;

public class LobbyListPresenter implements I_LobbyListListener, I_LobbyChangeListener
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
        mainListener.showCreateLobbyUI();
    }
}
