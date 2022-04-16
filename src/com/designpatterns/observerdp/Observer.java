package com.designpatterns.observerdp;


/**
 * Created by dhanetwa on 6/17/2018.
 */
public interface Observer {
    void update(Observable observable, Object object);

    default void abc() {

    }
}
