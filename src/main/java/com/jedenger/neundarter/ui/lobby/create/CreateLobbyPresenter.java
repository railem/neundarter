package com.jedenger.neundarter.ui.lobby.create;

import com.jedenger.neundarter.game.lobby.I_LobbyChangeListener;
import com.jedenger.neundarter.game.lobby.Lobby;
import com.jedenger.neundarter.game.lobby.Player;
import com.jedenger.neundarter.game.lobby.S_LobbyManager;
import com.jedenger.neundarter.ui.I_MainListener;
import com.vaadin.ui.VerticalLayout;

public class CreateLobbyPresenter implements I_CreateLobbyListener
{
    private I_MainListener mainListener;
    private S_LobbyManager lobbyManager;
    private VerticalLayout layout;
    private Player player;

    private CreateLobbyUI createLobbyUI;
    private Lobby currentLobby;

    public CreateLobbyPresenter( I_MainListener mainListener, VerticalLayout mainLayout, Player player ) 
    {
        this.mainListener = mainListener;
        this.layout = mainLayout;
        this.player = player;
        this.lobbyManager = S_LobbyManager.getInstance();

        currentLobby = lobbyManager.createLobby( player );
        this.createLobbyUI = new CreateLobbyUI( this, layout );
    }

    @Override
    public void showLobbyList() 
    {
        lobbyManager.leaveLobby( player, currentLobby );
        mainListener.showLobbyListUI();
    }


}