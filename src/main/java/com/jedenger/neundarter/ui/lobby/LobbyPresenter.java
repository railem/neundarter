package com.jedenger.neundarter.ui.lobby;

import com.jedenger.neundarter.game.lobby.Lobby;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class LobbyPresenter implements I_LobbyListener
{

    private LobbyUI lobbyUI;

    public LobbyPresenter( VerticalLayout layout )
    {
        this.lobbyUI = new LobbyUI( this, layout );
    }

    @Override
    public List<Lobby> getLobbies()
    {
        List<Lobby> lobbies = new ArrayList<>();
        lobbies.add( new Lobby( "new Game 1") );
        lobbies.add( new Lobby( "xxx") );
        lobbies.add( new Lobby( "awfaf") );
        lobbies.add( new Lobby( "nawg") );
        lobbies.add( new Lobby( "awaaw Game Game!") );

        return lobbies;
    }
}
