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
        try {
            String eventName = eventDataAccessObject.modify(
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

            ModifyOutputData modifyOutputData = new ModifyOutputData(eventName, events);
            modifyPresenter.prepareSuccessView(modifyOutputData);

        } catch (Exception e) {
            modifyPresenter.prepareFailView(e.getMessage());
        }
    }
}
