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

        Grid.Column idCol = lobbyGrid.addColumn( Lobby::getId ).setCaption( "Id" );
        Grid.Column nameCol = lobbyGrid.addColumn( Lobby::getName ).setCaption( "Name" );
        Grid.Column playersCol = lobbyGrid.addColumn( lobby -> lobby.getPlayers().size() + "/2" ).setCaption( "Players" );
        Grid.Column typeCol = lobbyGrid.addColumn( lobby -> lobby.getGameOptions().getGameType().name() ).setCaption( "GameType" );



        lobbyGrid.setItems( lobbyListener.getLobbies() );

        lobbyGrid.setSizeFull();
        layout.addComponent(lobbyGrid);
        layout.setExpandRatio(lobbyGrid, 1f);
    }
}
