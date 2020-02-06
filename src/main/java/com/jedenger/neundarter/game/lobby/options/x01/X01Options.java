package com.jedenger.neundarter.game.lobby.options.x01;

import com.jedenger.neundarter.game.lobby.options.I_GameOptions;

public class X01Options implements I_GameOptions
{
    private E_InMode inMode;
    private E_OutMode outMode;
    private E_StartPoints startPoints;

    private int legs;
    private int sets;

    public X01Options() 
    {
        this.inMode = E_InMode.SINGLE_IN;
        this.outMode = E_OutMode.DOUBLE_OUT;
        this.startPoints = E_StartPoints.X501;

        this.legs = 5;
        this.sets = 1;
    }

    @Override
    public int getLegs()
    {
        return legs;
    }

    @Override
    public int getSets()
    {
        return sets;
    }

    @Override
    public String getMode()
    {
        return "" + startPoints.getPoints();
    }

    @Override
    public String getOptions()
    {
        return inMode.name() + " | " + outMode.name();
    }

    public E_InMode getInMode() {
        return inMode;
    }

    public void setInMode(E_InMode inMode) {
        this.inMode = inMode;
    }

    public E_OutMode getOutMode() {
        return outMode;
    }

    public void setOutMode(E_OutMode outMode) {
        this.outMode = outMode;
    }

    public E_StartPoints getStartPoints() {
        return startPoints;
    }

    public void setStartPoints(E_StartPoints startPoints) {
        this.startPoints = startPoints;
    }
    
}
