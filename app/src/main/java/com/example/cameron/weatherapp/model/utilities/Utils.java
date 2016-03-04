package com.example.cameron.weatherapp.model.utilities;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Cameron on 03/03/2016.
 */
public class Utils {

    public static String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?";
    public static String KEY = "65f5a08d253ca309928c6b847b7f1241";
    public static String LOCATION = "";

    /**
     *
     * @return Whole URL
     */
    public static String getCompleteURL() {

        String temp = BASE_URL + LOCATION + "&appid=" + KEY;
        return temp;
    }


    public static String getLocalURL() {
        String local = BASE_URL;
        return local;
    }


    /**
     *
     * @param context
     * @param latitude
     * @param longitude
     * @return
     * @throws IOException
     */
    public static String getAddress(Context context, double latitude,
                                    double longitude) throws IOException {
        Geocoder myLocation = new Geocoder(context, Locale.getDefault());
        List<Address> myList = myLocation.getFromLocation(latitude, longitude,
                1);

        String addressStr = "";

        Address address = (Address) myList.get(0);

        addressStr += address.getAddressLine(0) + ", ";
        addressStr += address.getCountryName();

        return addressStr;
    }

    /**
     * This method takes one parameter and returns true if network is available
     *
     * @param context
     *            set the ConnectivityManager application context
     * @return boolean
     * @see NetworkInfo
     */
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
