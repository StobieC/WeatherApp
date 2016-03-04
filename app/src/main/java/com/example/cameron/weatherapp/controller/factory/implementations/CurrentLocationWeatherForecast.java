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
import com.example.cameron.weatherapp.model.model.WeatherForecast;
import com.example.cameron.weatherapp.model.utilities.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Cameron on 03/03/2016.
 */
public class CurrentLocationWeatherForecast extends WeatherForecastAbstract {

    private Context context = null;
    private WeatherForecastInterface weatherForecastInterface = null;
    private RequestQueue queue = null;
    private WeatherForecast weatherForecast = null;
    private ArrayList<WeatherForecast> weatherForecasts = new ArrayList<WeatherForecast>();

    public CurrentLocationWeatherForecast(Context context,
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

                        weatherForecast = new WeatherForecast();

                        try {

                            JSONObject jo = response.getJSONObject("main");

                            } catch (JSONException e) {
                            Log.e("Volley Error", e.getMessage());
                            e.printStackTrace();
                        }

                        weatherForecasts.add(weatherForecast);

                        weatherForecastInterface.success(weatherForecasts);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                weatherForecastInterface.error(error.toString());
            }

        });

        queue.add(jsObjRequest);


        Log.d("CurrentLocation","URL: " + jsObjRequest.getUrl());

        String response = "Added to Request Queue!";

        return response;
    }

}
