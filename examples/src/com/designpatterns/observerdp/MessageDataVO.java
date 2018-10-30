package com.designpatterns.observerdp;

/**
 * Created by dhanetwa on 6/17/2018.
 */
// This is subject
public class MessageDataVO extends Observable {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        setChanged();
        notifyObservers(message);
    }
}
