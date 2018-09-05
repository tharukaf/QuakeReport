package com.example.android.quakereport;

/**
 * Created by Tharuka on 6/30/2017.
 */

public class Earthquake {

    private String mEarthquakeMagnitude;  //Name of the earthquake
    private String mEarthquakeLocation; //Location of the earthquake
    private String mEarthquakeDate; //Date of the earthquake
    private String mUrl; //URL of the link


    //Public constructor for the Earthquake class
    public Earthquake(String magnitude, String earthquakeLocation, String earthquakeDate, String url){
        mEarthquakeMagnitude = magnitude;
        mEarthquakeLocation = earthquakeLocation;
        mEarthquakeDate = earthquakeDate;
        mUrl = url;

    }

    //Getters for the private instance variables
    public String getmEarthquakeMagnitude() {
        return mEarthquakeMagnitude;
    }

    public String getmEarthquakeDate() {
        return mEarthquakeDate;
    }

    public String getmEarthquakeLocation() {
        return mEarthquakeLocation;
    }

    public String getmUrl() {
        return mUrl;
    }

}
