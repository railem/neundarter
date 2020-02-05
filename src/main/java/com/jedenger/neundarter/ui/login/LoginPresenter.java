package com.jedenger.neundarter.ui.login;

import com.jedenger.neundarter.game.lobby.Player;
import com.jedenger.neundarter.ui.I_MainListener;
import com.vaadin.ui.VerticalLayout;

public class LoginPresenter implements I_LoginListener
{
    private I_MainListener mainListener;
    private VerticalLayout mainLayout;

    public LoginPresenter( I_MainListener mainListener, VerticalLayout mainLayout ) 
    {
        this.mainLayout = mainLayout;
        this.mainListener = mainListener;
        
        LoginUI loginUI = new LoginUI( this, mainLayout );
    }

    @Override
    public void login( String name ) 
    {
        mainListener.login( new Player( name ) );
    }

}