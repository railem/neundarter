package com.jedenger.neundarter.ui.lobby;

import com.jedenger.neundarter.game.lobby.Lobby;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

public class LobbyUI
{

    private final I_LobbyListener lobbyListener;
    private final VerticalLayout layout;

    private Grid<Lobby> lobbyGrid;

    public LobbyUI( I_LobbyListener lobbyListener, VerticalLayout layout )
    {
        this.lobbyListener = lobbyListener;
        this.layout = layout;

        initLobbyGrid();
    }

    private void initLobbyGrid()
    {
        lobbyGrid = new Grid<Lobby>();

        lobbyGrid.setItems( lobbyListener.getLobbies() );
    }
}
