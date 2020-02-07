package com.jedenger.neundarter.ui.lobby.create;

import com.jedenger.neundarter.game.lobby.Lobby;
import com.jedenger.neundarter.game.lobby.Player;
import com.jedenger.neundarter.game.lobby.S_LobbyManager;
import com.jedenger.neundarter.game.lobby.options.I_LobbyUpdateListener;
import com.jedenger.neundarter.ui.I_MainListener;
import com.vaadin.ui.VerticalLayout;

public class CreateLobbyPresenter implements I_CreateLobbyListener, I_LobbyUpdateListener
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
        this.createLobbyUI = new CreateLobbyUI( this, layout );

        currentLobby = lobbyManager.createLobby( player );

        lobbyManager.registerListener( currentLobby.getId(), this );
    }

    public CreateLobbyPresenter( I_MainListener mainListener, VerticalLayout mainLayout, Player player, Lobby lobby )
    {
        this.mainListener = mainListener;
        this.layout = mainLayout;
        this.player = player;
        this.lobbyManager = S_LobbyManager.getInstance();
        this.createLobbyUI = new CreateLobbyUI( this, layout );

        currentLobby = lobby;

        lobbyManager.registerListener( currentLobby.getId(), this );
    }

    @Override
    public void showLobbyList() 
    {
        lobbyManager.leaveLobby( player, currentLobby );
        mainListener.showLobbyListUI();
    }


    @Override
    public void lobbyUpdated( Lobby lobby )
    {
        if( currentLobby == lobby )
        {
            //TODO UPDATE UI
        }
    }
}