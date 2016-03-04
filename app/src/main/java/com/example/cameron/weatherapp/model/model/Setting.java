package com.example.cameron.weatherapp.model.model;

import java.util.ArrayList;

/**
 * Created by Cameron on 03/03/2016.
 */
public class Setting {

    private ArrayList<String> cities = null;
    private String forecastDay = "";
    private String showIcon = "";

    public ArrayList<String> getCities() {
            return cities;
        }

    public void setCities(ArrayList<String> cities) {
            this.cities = cities;
        }

    public String getForecastDay() {
            return forecastDay;
        }

    public void setForecastDay(String forecastDay) {
            this.forecastDay = forecastDay;
        }

    public String getShowIcon() {
            return showIcon;
        }

    public void setShowIcon(String showIcon) {
            this.showIcon = showIcon;
        }

}
