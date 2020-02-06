package com.jedenger.neundarter.ui;

import com.jedenger.neundarter.game.lobby.Lobby;
import com.jedenger.neundarter.game.lobby.Player;

public interface I_MainListener 
{
    void login( Player player );
    
    void showLobbyDetailsUI();
    void showLobbyDetailsUI( Lobby lobby );
    void showLobbyListUI();
}
