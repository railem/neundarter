package com.jedenger.neundarter.ui.lobby;

import com.jedenger.neundarter.game.lobby.Lobby;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;

import java.util.List;

public class LobbyListUI
{

    private final I_LobbyListListener lobbyListener;
    private final VerticalLayout layout;

    private Grid<Lobby> lobbyGrid;

    public LobbyListUI(I_LobbyListListener lobbyListener, VerticalLayout layout )
    {
        this.lobbyListener = lobbyListener;
        this.layout = layout;
        layout.removeAllComponents();

        init();
    }

    private void init()
    {
        layout.removeAllComponents();
        initLobbyGrid();

        Button createLobbyButton = new Button("Create Lobby");
        createLobbyButton.addClickListener( clickEvent -> lobbyListener.showCreateLobbyUI() );
        layout.addComponent( createLobbyButton );
    }


    private void initLobbyGrid()
    {
        lobbyGrid = new Grid<Lobby>();
        Grid.Column nameCol = lobbyGrid.addColumn( Lobby::getName ).setCaption( "Name" );
        Grid.Column playersCol = lobbyGrid.addColumn( lobby -> lobby.getPlayers().size() + "/" + lobby.getMaxPlayers() ).setCaption( "Players" );
        Grid.Column typeCol = lobbyGrid.addColumn( lobby -> lobby.getGameType().name() ).setCaption( "GameType" );
        Grid.Column modeCol = lobbyGrid.addColumn( lobby -> lobby.getGameOptions().getInfo() ).setCaption( "Info" );

        lobbyGrid.setSizeFull();
        layout.addComponent(lobbyGrid);
        layout.setExpandRatio(lobbyGrid, 1f);
    }


    public void setLobbyList(List<Lobby> lobbies)
    {
        lobbyGrid.setItems( lobbies );
    }
}
