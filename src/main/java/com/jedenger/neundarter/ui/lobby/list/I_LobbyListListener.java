package com.jedenger.neundarter.ui.lobby.list;


import com.jedenger.neundarter.game.lobby.Lobby;

public interface I_LobbyListListener
{
    void showCreateLobbyUI();
    void joinLobby( Lobby lobby );
}
