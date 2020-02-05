package com.jedenger.neundarter.ui;

import com.jedenger.neundarter.game.lobby.Player;

public interface I_MainListener 
{
    void login( Player player );
    
    void showCreateLobbyUI();
    void showLobbyListUI();
}
