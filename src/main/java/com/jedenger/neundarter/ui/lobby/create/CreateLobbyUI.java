package com.jedenger.neundarter.ui.lobby.create;

import com.jedenger.neundarter.game.lobby.Lobby;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

public class CreateLobbyUI
{

    private final I_CreateLobbyListener lobbyListener;
    private final VerticalLayout layout;

    public CreateLobbyUI( I_CreateLobbyListener lobbyListener, VerticalLayout layout )
    {
        this.lobbyListener = lobbyListener;
        this.layout = layout;
        layout.removeAllComponents();

        init();
    }

    private void init()
    {
        Button backbutton = new Button("back");
        backbutton.addClickListener( clickEvent -> lobbyListener.showLobbyList() );
        layout.addComponent( backbutton );
    }
}
