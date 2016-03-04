package com.example.cameron.weatherapp.controller.factory;

import android.content.Context;

import com.example.cameron.weatherapp.controller.abstracts.WeatherForecastAbstract;
import com.example.cameron.weatherapp.controller.abstracts.WeatherForecastInterface;
import com.example.cameron.weatherapp.controller.factory.implementations.CurrentLocationWeatherForecast;
import com.example.cameron.weatherapp.controller.factory.implementations.SpecifiedLocationWeatherForecast;
import com.example.cameron.weatherapp.controller.service.GPSTrackerService;
import com.example.cameron.weatherapp.model.utilities.Utils;

/**
 * Created by Cameron on 03/03/2016.
 */
public class WeatherForecastFactory {

    public static WeatherForecastAbstract getForecast(Context context,
                                                      String type, WeatherForecastInterface weatherForecastInterface,
                                                      String city, int numberOfDay) {



        if (type.equalsIgnoreCase("current")) {

            GPSTrackerService gpsTracker = new GPSTrackerService(context);

            Utils.LOCATION = "lat=" + gpsTracker.getLatitude() + "&lon="
                    + gpsTracker.getLongitude();

            return new CurrentLocationWeatherForecast(context,
                    weatherForecastInterface);
        }

        else if (type.equalsIgnoreCase("city")) {

            Utils.LOCATION = "q=" + city;
            return new SpecifiedLocationWeatherForecast(context,
                    weatherForecastInterface);
        }
        return null;
    }

}
