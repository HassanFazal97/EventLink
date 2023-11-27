package com.example.eventlink.view;

import com.example.eventlink.interface_adapter.Controller;
import com.example.eventlink.interface_adapter.ViewModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public abstract class ViewController{
    private Controller controller;
    private ViewModel viewModel;

    public void setController(Controller controller){this.controller = controller;}
    public void setViewModel(ViewModel viewModel){this.viewModel = viewModel;}
}
