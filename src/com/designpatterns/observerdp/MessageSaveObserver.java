package com.designpatterns.observerdp;

/**
 * Created by dhanetwa on 6/17/2018.
 */
public class MessageSaveObserver implements Observer {
    @Override
    public void update(Observable observable, Object object) {
        System.out.println("Message to save: " + object);
    }
}
