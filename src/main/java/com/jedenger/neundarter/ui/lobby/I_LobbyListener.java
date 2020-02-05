package com.jedenger.neundarter.ui.lobby;


import com.jedenger.neundarter.game.lobby.Lobby;

public interface I_LobbyListener
{
    void listLobbies();
    void createLobby();
    void joinLobby( Lobby lobby );
}
