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
        String start = modifyInputData.getStart();
        String end = modifyInputData.getEnd();
        String currency = modifyInputData.getCurrency();
        String summary = modifyInputData.getSummary();
        Boolean isPrivate = modifyInputData.getIsPrivate();

        eventDataAccessObject.modify(id, name, start, end, currency, summary, isPrivate);

        ModifyOutputData modifyOutputData = new ModifyOutputData(false);
        modifyPresenter.prepareSuccessView(modifyOutputData);
    }
}
