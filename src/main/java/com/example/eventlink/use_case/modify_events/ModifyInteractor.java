package com.example.eventlink.use_case.modify_events;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;

import java.util.List;

public class ModifyInteractor implements ModifyInputBoundary {

    final ModifyEventDataAccessInterface eventDataAccessObject;
    final ModifyOutputBoundary modifyPresenter;

    public ModifyInteractor(ModifyEventDataAccessInterface eventDataAccessObject, ModifyOutputBoundary modifyPresenter) {
        this.eventDataAccessObject = eventDataAccessObject;
        this.modifyPresenter = modifyPresenter;
    }

    @Override
    public void execute(ModifyInputData modifyInputData) {
        if (eventDataAccessObject.get(modifyInputData.getId()) == null) {
            modifyPresenter.prepareFailView("Event not found.");
            return;
        }
        try {
            String eventID = eventDataAccessObject.modify(
                    modifyInputData.getId(),
                    modifyInputData.getName(),
                    modifyInputData.getStartDate(),
                    modifyInputData.getStartTime(),
                    modifyInputData.getEndDate(),
                    modifyInputData.getEndTime(),
                    modifyInputData.getCurrency(),
                    modifyInputData.getSummary(),
                    modifyInputData.getIsPrivate());
            List<Event> events = eventDataAccessObject.getAllEvents();
            Event event = eventDataAccessObject.get(eventID);
            String eventName = event.getName();

            ModifyOutputData modifyOutputData = new ModifyOutputData(eventName, events);
            modifyPresenter.prepareSuccessView(modifyOutputData);

        } catch (Exception e) {
            modifyPresenter.prepareFailView(e.getMessage());
        }
    }
}
