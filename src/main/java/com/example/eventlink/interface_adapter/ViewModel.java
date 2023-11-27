package com.example.eventlink.interface_adapter;

import com.example.eventlink.interface_adapter.login.LoginState;

import java.beans.PropertyChangeListener;

public abstract class ViewModel {

    private String viewName;

    public ViewModel(String viewName) {this.viewName = viewName;}
    public String getViewName() {return viewName;}
}
