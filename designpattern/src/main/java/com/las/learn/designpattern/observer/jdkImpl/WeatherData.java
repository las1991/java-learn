package com.las.learn.designpattern.observer.jdkImpl;

import java.util.Observable;

public class WeatherData extends Observable {

    private float temp;
    private float humidity;
    private float presure;

    public WeatherData() {

    }

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public float getTemp() {
        return temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPresure() {
        return presure;
    }
}
