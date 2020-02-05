package com.jedenger.neundarter.ui.lobby;

import com.jedenger.neundarter.game.lobby.I_LobbyChangeListener;
import com.jedenger.neundarter.game.lobby.Lobby;
import com.jedenger.neundarter.game.lobby.S_LobbyManager;
import com.vaadin.ui.VerticalLayout;

public class LobbyPresenter implements I_LobbyListener, I_LobbyChangeListener
{
    private S_LobbyManager lobbyManager;
    private VerticalLayout layout;

    private LobbyListUI lobbyListUI;
    private CreateLobbyUI createLobbyUI;

    public LobbyPresenter( VerticalLayout layout )
    {
        this.layout = layout;
        this.lobbyManager = S_LobbyManager.getInstance();
    }


    @Override
    public void lobbyListChanged()
    {
        lobbyListUI.setLobbyList( lobbyManager.getLobbies() );
    }


    @Override
    public void listLobbies()
    {
        this.lobbyListUI = new LobbyListUI( this, layout );

        lobbyListUI.setLobbyList( lobbyManager.getLobbies() );
        lobbyManager.registerListener( this );
    }

    @Override
    public void createLobby()
    {
        lobbyManager.unregisterListener( this );

        // create new lobby

        this.createLobbyUI = new CreateLobbyUI( this, layout );
    }

    @Override
    public void joinLobby( Lobby lobby )
    {
        lobbyManager.unregisterListener( this );
    }
}
