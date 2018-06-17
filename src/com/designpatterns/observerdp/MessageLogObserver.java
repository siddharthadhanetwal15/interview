package com.designpatterns.observerdp;

/**
 * Created by dhanetwa on 6/17/2018.
 */
public class MessageLogObserver implements Observer {
    @Override
    public void update(Observable observable, Object object) {
        System.out.println("Message to log: " + object);
    }
}
