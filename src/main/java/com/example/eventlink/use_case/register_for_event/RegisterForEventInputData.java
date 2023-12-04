package com.example.eventlink.use_case.register_for_event;


import com.example.eventlink.entity.event.Event;

/**
 * The RegisterForEventInputData class represents the input data needed for the RegisterForEvent use case.
 * It encapsulates and stores  information such as the event details, participant's name, last name, username,
 * and payment fee.
 */
public class RegisterForEventInputData {
    /**
     * The event that the user is registering for.
     */
    private final String event;
    /**
     * The user's first name.
     */
    private final String name;
    /**
     * The user's last name.
     */
    private final String lastName;
    /**
     * The user's username.
     */
    private final String username;
    /**
     * The payment fee associated with the event registration.
     */
    private final String paymentFee;


    /**
     * Constructs a new instance of RegisterForEventInputData with the specified details.
     *
     * @param event       The event that the user is registering for.
     * @param name        The user's first name.
     * @param lastName    The user's last name.
     * @param username    The user's username.
     * @param paymentFee  The payment fee associated with the event registration.
     */
    public RegisterForEventInputData(String event, String name, String lastName, String username, String paymentFee) {
        this.event = event;
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.paymentFee = paymentFee;
    }
    /**
     * Gets the event that the user is registering for.
     *
     * @return The Event object representing the event details.
     */
    public String getEvent() {
        return event;
    }
    /**
     * Gets the user's first name.
     *
     * @return The user's first name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the user's last name.
     *
     * @return The user's last name.
     */
    public String getLastName() {
        return lastName;
    }
    /**
     * Gets the user's username.
     *
     * @return The user's username.
     */
    public String getUsername() {
        return username;
    }
    /**
     * Gets the payment fee associated with the event registration.
     *
     * @return The payment fee as a string.
     */
    public String getPaymentFee() {
        return paymentFee;
    }
}
