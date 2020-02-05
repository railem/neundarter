package com.jedenger.neundarter.ui;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("darttheme")
@Push
public class MainUI extends UI
{

    @Override
    protected void init(VaadinRequest vaadinRequest)
    {
        setPollInterval(500);
        final VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setSizeFull();
        setContent( mainLayout );

        MainPresenter mainPresenter = new MainPresenter( mainLayout );
    }

    @WebServlet( urlPatterns = "/*", name = "MainUIServlet", asyncSupported = true )
    @VaadinServletConfiguration( ui = MainUI.class, productionMode = false )
    public static class MainUIServlet extends VaadinServlet
    {
    }
}
