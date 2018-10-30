package com.designpatterns.observerdp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dhanetwa on 6/17/2018.
 */
public class Observable {
    private boolean changed = false;
    private List<Observer> observers;
    Observable(){
        observers = new ArrayList<>();
    }

    public synchronized void  addObserver(Observer observer){
        if(observer==null){
            throw new NullPointerException();
        }
        if(!observers.contains(observer)){
            observers.add(observer);
        }
    }

    public void notifyObserver(){
        notifyObservers(null);
    }

    public void notifyObservers(Object object){
        synchronized (this){
            if(!changed) {
                return;
            }
            clearChanged();
        for (Observer observer : observers){
                observer.update(this, object);
        }
        }
    }
    public synchronized void deleteObservers(){
        observers.clear();
    }
    protected synchronized void setChanged(){
        changed = true;
    }
    protected synchronized void clearChanged(){
        changed = false;
    }
    public synchronized boolean hasChanged(){
        return changed;
    }
    public synchronized int countObservers(){
        return observers.size();
    }
}
