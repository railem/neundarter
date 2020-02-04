package com.jedenger.neundarter.ui.lobby;

import com.jedenger.neundarter.game.lobby.Lobby;
import com.vaadin.ui.VerticalLayout;

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
        return null;
    }
}
