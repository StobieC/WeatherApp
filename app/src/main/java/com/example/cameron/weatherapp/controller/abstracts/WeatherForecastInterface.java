package com.example.cameron.weatherapp.controller.abstracts;

import android.content.Context;

import com.example.cameron.weatherapp.model.model.WeatherForecast;

import java.util.ArrayList;

/**
 * Created by Cameron on 03/03/2016.
 */
public interface WeatherForecastInterface {

    public void success(ArrayList<WeatherForecast> weatherForecasts);

    public void error(String errorMsg);

    public Context getWeatherForecastContext();

}
