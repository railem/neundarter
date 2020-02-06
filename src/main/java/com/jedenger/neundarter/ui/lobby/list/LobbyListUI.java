package com.jedenger.neundarter.ui.lobby.list;

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

        Button joinLobbyButton = new Button("Join Lobby");
        joinLobbyButton.addClickListener( clickEvent -> lobbyListener.joinLobby( lobbyGrid.asSingleSelect().getSelectedItem().get() ) );
        layout.addComponent( joinLobbyButton );
    }


    private void initLobbyGrid()
    {
        lobbyGrid = new Grid<Lobby>();
        Grid.Column nameCol = lobbyGrid.addColumn( Lobby::getName ).setCaption( "Name" );
        Grid.Column playersCol = lobbyGrid.addColumn( lobby -> lobby.getPlayers().size() + "/" + lobby.getMaxPlayers() ).setCaption( "Players" );
        Grid.Column typeCol = lobbyGrid.addColumn( lobby -> lobby.getGameType().name() ).setCaption( "GameType" );

        Grid.Column modeCol = lobbyGrid.addColumn( lobby -> lobby.getGameOptions().getMode() ).setCaption( "Mode" );
        Grid.Column optionsCol = lobbyGrid.addColumn( lobby -> lobby.getGameOptions().getOptions() ).setCaption( "Options" );

        Grid.Column legsCol = lobbyGrid.addColumn( lobby -> lobby.getGameOptions().getLegs() ).setCaption( "Legs" );
        legsCol.setWidth( 80d );
        Grid.Column setsCol = lobbyGrid.addColumn( lobby -> lobby.getGameOptions().getSets() ).setCaption( "Sets" );
        setsCol.setWidth( 80d );

        lobbyGrid.setSizeFull();
        layout.addComponent(lobbyGrid);
        layout.setExpandRatio(lobbyGrid, 1f);
    }


    public void setLobbyList(List<Lobby> lobbies)
    {
        lobbyGrid.setItems( lobbies );
    }
}
