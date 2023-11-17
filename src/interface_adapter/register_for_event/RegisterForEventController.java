package interface_adapter.register_for_event;

import entity.event.Event;
import use_case.register_for_event.RegisterForEventInputBoundary;
import use_case.register_for_event.RegisterForEventInputData;

public class RegisterForEventController {
    final RegisterForEventInputBoundary registerForEventUseCaseInteractor;

    public RegisterForEventController(RegisterForEventInputBoundary registerForEventUseCaseInteractor) {
        this.registerForEventUseCaseInteractor = registerForEventUseCaseInteractor;
    }

    public void execute(Event event,String name, String email, String lastName, String paymentFee) {
        RegisterForEventInputData RegisterForEventInputData = new RegisterForEventInputData(
                event, name, lastName, email, paymentFee);
        registerForEventUseCaseInteractor.execute(RegisterForEventInputData);
    }

}
