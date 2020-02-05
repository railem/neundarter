package com.jedenger.neundarter.game.lobby;

import java.util.UUID;

public class Player 
{
    private String id;
    private String name;

    public Player( String name ) 
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    
    
}
