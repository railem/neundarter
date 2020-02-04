package com.jedenger.neundarter.game.lobby;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Lobby
{
    private String id;
    private String name;
    private List<Player> players;
    private GameOptions gameOptions;

    public Lobby(String name) 
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.players = new ArrayList<>();
        this.gameOptions = new GameOptions( E_GameType.X01 );
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GameOptions getGameOptions() {
        return gameOptions;
    }

    public void setGameOptions(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    
    
}
