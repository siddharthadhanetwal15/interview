package com.designpatterns.observerdp;

/**
 * Created by dhanetwa on 6/17/2018.
 */
public class ObserverTestClient {
    public static void main(String[] args) {
        MessageDataVO messageDataVO = new MessageDataVO();
        //now creating observers for subject messagedatavo
        messageDataVO.addObserver(new MessageUIObserver());
        messageDataVO.addObserver(new MessageSaveObserver());
        messageDataVO.addObserver(new MessageLogObserver());
        //now all observers are registered for receiving message updates.
        //now we will change the message in dataVO
        messageDataVO.setMessage("this is observer test message");
        //all Observers will receive this message via notification
    }
}
