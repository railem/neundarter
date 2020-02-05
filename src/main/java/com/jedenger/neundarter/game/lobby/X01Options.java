package com.jedenger.neundarter.game.lobby;

public class X01Options implements I_GameOptions
{
    private E_InMode inMode;
    private E_OutMode outMode;
    private E_StartPoints startPoints;

    public X01Options() 
    {
        this.inMode = E_InMode.SINGLE_IN;
        this.outMode = E_OutMode.DOUBLE_OUT;
        this.startPoints = E_StartPoints.X501;
    }

    @Override
    public String getInfo() 
    {
        String infoString = "";

        infoString += startPoints.name() + " | ";
        if( inMode != E_InMode.SINGLE_IN )
        {
            infoString += inMode.name() + " | ";
        }
        infoString += outMode.name();

        return infoString;
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
