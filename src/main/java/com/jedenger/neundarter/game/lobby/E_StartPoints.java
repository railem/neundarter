package com.jedenger.neundarter.game.lobby;

public enum E_StartPoints 
{
    X170(170), X301(301), X501(501);

    private int points;
    private E_StartPoints( int points ) 
    {
        this.points = points;
    }

    public int getPoints() 
    {
        return points;
    }    
}
