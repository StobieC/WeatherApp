package com.example.cameron.weatherapp.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.cameron.weatherapp.R;
import com.example.cameron.weatherapp.controller.Controller;
import com.example.cameron.weatherapp.model.model.WeatherForecast;
import java.text.DecimalFormat;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Cameron on 03/03/2016.
 */
public class WeatherForecastAdapter extends ArrayAdapter<WeatherForecast> {

    private List<WeatherForecast> lists = null;
    private Context context = null;
    private Controller controller = null;

    public WeatherForecastAdapter(Context context,
                                  List<WeatherForecast> objects, Controller controller) {
        super(context, R.layout.weather_forecast_row, objects);
        this.lists = objects;
        this.context = context;
        this.controller = controller;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(
                    R.layout.weather_forecast_row, parent, false);

            holder = new ViewHolder();

            holder.forecastMinC = (TextView) convertView
                    .findViewById(R.id.forecastMinKelvin);

            holder.forecastMaxC = (TextView) convertView
                    .findViewById(R.id.forecastMaxKelvin);
            holder.forecastAverageC = (TextView) convertView
                    .findViewById(R.id.forecastAverage);
            holder.windDeg =(TextView) convertView
                    .findViewById(R.id.windDegreesTxt);
            holder.windSpeed =(TextView) convertView
                    .findViewById(R.id.windSpeedTxt);

            convertView.setTag(holder);

            convertView.setTag(R.id.forecastMinKelvin, holder.forecastMinC);
            convertView.setTag(R.id.forecastMaxKelvin, holder.forecastMaxC);
            convertView.setTag(R.id.forecastAverage, holder.forecastAverageC);



        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        WeatherForecast currentWeatherForecast = lists.get(position);

        double minKtoC =  Double.parseDouble(currentWeatherForecast.getMinCelciusTemperature())-273;
        double maxKtoC =  Double.parseDouble(currentWeatherForecast.getMaxCelciusTemperature())-273;
        DecimalFormat df = new DecimalFormat("#.##");
        minKtoC = Double.valueOf(df.format(minKtoC));
        maxKtoC = Double.valueOf(df.format(maxKtoC));

        holder.forecastMinC.setText("Min:"
                                + maxKtoC + "° C");

        holder.forecastMaxC.setText("Max: "
                + minKtoC + "° C");

        double celsiusAverage = (Double.parseDouble(currentWeatherForecast
                .getMaxCelciusTemperature()) + Double
                .parseDouble(currentWeatherForecast.getMinCelciusTemperature())) / 2 -273;

        holder.forecastAverageC.setText("Average: " + celsiusAverage + "° C");

        holder.windDeg.setText(currentWeatherForecast.getWindDegrees()
                                + "°");
        holder.windSpeed.setText(currentWeatherForecast.getWindSpeed()
                                + "mph");


        return convertView;
    }

    public static class ViewHolder {


        public TextView forecastMinC, forecastMaxC;
        public TextView windDeg, windSpeed;
        public TextView forecastAverageC;

    }

}
