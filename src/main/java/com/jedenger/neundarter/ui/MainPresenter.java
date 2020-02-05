package com.jedenger.neundarter.ui;

import com.jedenger.neundarter.ui.lobby.LobbyPresenter;
import com.vaadin.ui.VerticalLayout;

public class MainPresenter
{

    private VerticalLayout mainLayout;

    public MainPresenter( VerticalLayout mainLayout )
    {
        this.mainLayout = mainLayout;
        //login

        LobbyPresenter lobbyPresenter = new LobbyPresenter( mainLayout );
        lobbyPresenter.listLobbies();
    }
}
