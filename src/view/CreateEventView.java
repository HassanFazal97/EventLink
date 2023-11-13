package view;

import interface_adapter.create_events.CreateEventState;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreateEventView implements ActionListener, PropertyChangeListener {
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        CreateEventState state = (CreateEventState) evt.getNewValue();
        if (state.getNameError() != null){

        }

    }
}
