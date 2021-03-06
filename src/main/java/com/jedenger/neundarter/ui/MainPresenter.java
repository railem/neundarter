package com.jedenger.neundarter.ui;

import com.jedenger.neundarter.game.lobby.Lobby;
import com.jedenger.neundarter.game.lobby.Player;
import com.jedenger.neundarter.ui.lobby.list.LobbyListPresenter;
import com.jedenger.neundarter.ui.lobby.create.CreateLobbyPresenter;
import com.jedenger.neundarter.ui.login.LoginPresenter;
import com.vaadin.ui.VerticalLayout;

public class MainPresenter implements I_MainListener
{

    private VerticalLayout mainLayout;
    private Player player;

    public MainPresenter( VerticalLayout mainLayout )
    {
        this.mainLayout = mainLayout;
        LoginPresenter loginPresenter = new LoginPresenter( this, mainLayout );
    }

    @Override
    public void login( Player player ) 
    {
        this.player = player;
        showLobbyListUI();
    }

    @Override
    public void showLobbyDetailsUI()
    {
        CreateLobbyPresenter lobbyCreatePresenter = new CreateLobbyPresenter( this, mainLayout, player );
    }

    @Override
    public void showLobbyDetailsUI( Lobby lobby )
    {
        CreateLobbyPresenter lobbyCreatePresenter = new CreateLobbyPresenter( this, mainLayout, player, lobby );
    }


    @Override
    public void showLobbyListUI() 
    {
        LobbyListPresenter lobbyListPresenter = new LobbyListPresenter( this, mainLayout, player );
    }
}
