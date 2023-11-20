package com.example.eventlink.use_case.modify_events;

import com.example.eventlink.entity.event.Event;
import com.example.eventlink.entity.event.EventFactory;

public class ModifyInteractor implements ModifyInputBoundary {

    final ModifyUserDataAccessInterface eventDataAccessObject;
    final ModifyOutputBoundary modifyPresenter;
    final EventFactory eventFactory;

    public ModifyInteractor(ModifyUserDataAccessInterface eventDataAccessObject, ModifyOutputBoundary modifyPresenter, EventFactory eventFactory) {
        this.eventDataAccessObject = eventDataAccessObject;
        this.modifyPresenter = modifyPresenter;
        this.eventFactory = eventFactory;
    }

    @Override
    public void execute(ModifyInputData modifyInputData) {
        //TODO: implement fail case where the ID could not be matched with an existing event
        Event event = eventFactory.create(modifyInputData.getName(), modifyInputData.getStart(), modifyInputData.getEnd(), modifyInputData.getCurrency(), modifyInputData.getSummary(), modifyInputData.getIsPrivate());
        eventDataAccessObject.save(event);

        ModifyOutputData modifyOutputData = new ModifyOutputData(false);
        modifyPresenter.prepareSuccessView(modifyOutputData);
    }
}
