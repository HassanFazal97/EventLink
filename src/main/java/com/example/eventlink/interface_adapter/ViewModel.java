package com.example.eventlink.interface_adapter;

import com.example.eventlink.interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;

public abstract class ViewModel {

    private final static String viewName = "";
    public ViewModel() {}
    public static String getViewName() {return viewName;}
}
