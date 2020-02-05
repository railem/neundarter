package com.jedenger.neundarter.ui.login;

import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginUI 
{

    private I_LoginListener loginListener;
    private VerticalLayout mainLayout;

    public LoginUI( I_LoginListener loginListener, VerticalLayout mainLayout ) 
    {
        this.loginListener = loginListener;
        this.mainLayout = mainLayout;

        TextField userNameTf = new TextField();

        Button loginBtn = new Button( "Login" );
        loginBtn.addClickListener( ce -> loginListener.login( userNameTf.getValue() ) );

        mainLayout.addComponents( userNameTf, loginBtn );
    }

}
