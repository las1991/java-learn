package com.las.learn.designpattern.observer.impl;

import java.util.ArrayList;

public class WeatherData implements Subject {

    private ArrayList<Observer> observers;

    private float temp;
    private float humidity;
    private float presure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index > 0) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(this.temp, this.humidity, this.presure);
        }
    }

    public void measurementsChanged() {
        notifyObserver();
    }

    public void setMeasurements(float temp, float humidity, float presure) {
        this.temp = temp;
        this.humidity = humidity;
        this.presure = presure;
        measurementsChanged();
    }
}
