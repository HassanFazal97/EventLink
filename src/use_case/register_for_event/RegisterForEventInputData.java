package use_case.register_for_event;


import entity.event.Event;

public class RegisterForEventInputData {

    private final Event event;
    private final String name;
    private final String lastName;
    private final String username;
    private final String paymentFee;


    public RegisterForEventInputData(Event event, String name, String lastName, String username, String paymentFee) {
        this.event = event;
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.paymentFee = paymentFee;
    }

    public Event getEvent() {
        return event;
    }

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPaymentFee() {
        return paymentFee;
    }
}
