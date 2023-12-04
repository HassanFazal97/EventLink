package com.example.eventlink.app.use_case_factories;

import com.example.eventlink.data_access.EventDataAccessObject;
import com.example.eventlink.interface_adapter.ViewManagerModel;
import com.example.eventlink.interface_adapter.guest_in.GuestViewModel;
import com.example.eventlink.interface_adapter.logged_in.LoggedInViewModel;
import com.example.eventlink.interface_adapter.modify_events.ModifyController;
import com.example.eventlink.interface_adapter.modify_events.ModifyPresenter;
import com.example.eventlink.interface_adapter.modify_events.ModifyViewModel;
import com.example.eventlink.use_case.modify_events.ModifyInputBoundary;
import com.example.eventlink.use_case.modify_events.ModifyInteractor;
import com.example.eventlink.use_case.modify_events.ModifyOutputBoundary;

public class ModifyEventUseCaseFactory {
    private ModifyEventUseCaseFactory() {}

    public static ModifyController create(
            ViewManagerModel viewManagerModel,
            ModifyViewModel modifyViewModel,
            LoggedInViewModel loggedInViewModel,
            GuestViewModel guestViewModel,
            EventDataAccessObject eventDataAccessObject
    ) {
        ModifyOutputBoundary modifyPresenter = new ModifyPresenter(modifyViewModel,
                loggedInViewModel, guestViewModel, viewManagerModel);

        ModifyInputBoundary modifyInteractor = new ModifyInteractor(eventDataAccessObject,modifyPresenter);

        return new ModifyController(modifyInteractor);
    }
}
