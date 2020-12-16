package com.las.learn.designpattern.observer.impl;

public class WeathreStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(80, 65, 30.4f);
    }
}
