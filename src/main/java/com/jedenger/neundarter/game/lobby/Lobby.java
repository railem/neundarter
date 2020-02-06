package com.jedenger.neundarter.game.lobby;

import com.jedenger.neundarter.game.lobby.options.cricket.CricketOptions;
import com.jedenger.neundarter.game.lobby.options.I_GameOptions;
import com.jedenger.neundarter.game.lobby.options.x01.X01Options;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Lobby
{
    private String id;
    private String name;
    private List<Player> players;
    private int maxPlayers;
    private E_GameType gameType;

    private I_GameOptions gameOptions;

    public Lobby()
    {
        this.id = UUID.randomUUID().toString();
        this.players = new ArrayList<>();
        this.gameType = E_GameType.X01;
        this.maxPlayers = 2;

        initGameOptions();
    }
    
    private void initGameOptions()
    {
        switch( gameType )
        {
            case X01:
                gameOptions = new X01Options();
                break;
            case CRICKET:
                gameOptions = new CricketOptions();
                break;
        }
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getId() 
    {
        return id;
    }

    public I_GameOptions getGameOptions() 
    {
        return gameOptions;
    }

    public List<Player> getPlayers() 
    {
        return players;
    }

    public E_GameType getGameType() 
    {
        return gameType;
    }

    
    public int getMaxPlayers() 
    {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) 
    {
        this.maxPlayers = maxPlayers;
    }

    public void setGameType(E_GameType gameType) 
    {
        this.gameType = gameType;
        initGameOptions();
    }

    public void join(Player player) 
    {
        this.players.add( player );
    }

    public void leave( Player player ) 
    {
        if( players.contains( player ) )
        {
            players.remove( player );
        }
    }    
    
}
