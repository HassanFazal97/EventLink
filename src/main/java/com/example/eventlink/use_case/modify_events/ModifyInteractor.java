package com.example.eventlink.use_case.modify_events;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;

public class ModifyInteractor implements ModifyInputBoundary {

    final ModifyEventDataAccessInterface eventDataAccessObject;
    final ModifyOutputBoundary modifyPresenter;
    final EventFactory eventFactory;

    public ModifyInteractor(ModifyEventDataAccessInterface eventDataAccessObject, ModifyOutputBoundary modifyPresenter, EventFactory eventFactory) {
        this.eventDataAccessObject = eventDataAccessObject;
        this.modifyPresenter = modifyPresenter;
        this.eventFactory = eventFactory;
    }

    @Override
    public void execute(ModifyInputData modifyInputData) {
        //TODO: implement fail case where the ID could not be matched with an existing event
        String id = modifyInputData.getId();
        String name = modifyInputData.getName();
        String startDate = modifyInputData.getStartDate();
        String startTime = modifyInputData.getStartTime();
        String endDate = modifyInputData.getEndDate();
        String endTime = modifyInputData.getEndTime();
        String currency = modifyInputData.getCurrency();
        String summary = modifyInputData.getSummary();
        Boolean isPrivate = modifyInputData.getIsPrivate();

        if (!eventDataAccessObject.existsById(id)) {
            modifyPresenter.prepareFailView("Event not found.");
        } else {
            eventDataAccessObject.modify(id, name, startDate, startTime, endDate, endTime, currency, summary, isPrivate);

            ModifyOutputData modifyOutputData = new ModifyOutputData(false);
            modifyPresenter.prepareSuccessView(modifyOutputData);
        }
    }
}
