package com.example.cameron.weatherapp.controller.factory.implementations;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.cameron.weatherapp.controller.abstracts.WeatherForecastAbstract;
import com.example.cameron.weatherapp.controller.abstracts.WeatherForecastInterface;
import com.example.cameron.weatherapp.model.model.CurrentCondition;
import com.example.cameron.weatherapp.model.model.WeatherForecast;
import com.example.cameron.weatherapp.model.utilities.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Cameron on 03/03/2016.
 */
public class SpecifiedLocationWeatherForecast extends WeatherForecastAbstract {

    private Context context = null;
    private WeatherForecastInterface weatherForecastInterface = null;
    private RequestQueue queue = null;
    private WeatherForecast weatherForecast = null;
    private ArrayList<WeatherForecast> forecastList = new ArrayList<WeatherForecast>();
    private CurrentCondition currentCondition = null;
    private String location = "", requestType = "", minC = "",
            maxC = "", windSpeed = "", windDeg = "";


    public SpecifiedLocationWeatherForecast(Context context,
                                            WeatherForecastInterface weatherForecastInterface) {
        super();
        this.context = context;
        this.weatherForecastInterface = weatherForecastInterface;
    }

    @Override
    public String execute() {

        queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest(
                Request.Method.POST, Utils.getCompleteURL(), null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        try {

                            JSONObject jo = response.getJSONObject("main");

                            maxC = jo.getString("temp_max");
                            minC = jo.getString("temp_min");

                            JSONObject joWind = response.getJSONObject("wind");

                            windDeg = joWind.getString("deg");
                            windSpeed = joWind.getString("speed");

                            weatherForecast = new WeatherForecast();
                            weatherForecast.setMaxCelciusTemperature(maxC);
                            weatherForecast.setMinCelciusTemperature(minC);
                            weatherForecast.setWindDegrees(windDeg);
                            weatherForecast.setWindSpeed(windSpeed);
                            weatherForecast.setRequestType(requestType);
                            weatherForecast.setCurrentCondition(currentCondition);

                            forecastList.add(weatherForecast);


                        }catch (JSONException e) {
                            Log.e("Volley Error", e.getMessage());
                            e.printStackTrace();
                        }

                        weatherForecastInterface.success(forecastList);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                weatherForecastInterface.error(error.toString());
            }
        });

        System.out.println("URL : " + jsObjRequest.getUrl());

        queue.add(jsObjRequest);

        String response = "Added to Request Queue!";

        return response;
    }

}
