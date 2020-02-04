package com.jedenger.neundarter.game.lobby;

public class GameOptions 
{
    private E_GameType gameType;

    public GameOptions(E_GameType gameType) 
    {
        this.gameType = gameType;
    }

    // private X01Options x01Options;
    // private CricketOptions cricketOptions;

    public E_GameType getGameType() {
        return gameType;
    }

    public void setGameType(E_GameType gameType) {
        this.gameType = gameType;
    }


    
}
