package com.example.android.quakereport;

/**
 * Created by Tharuka Fernando on 4/16/2017.
 */

public class Earthquake {


    private String mMagnitude;
    private String mLocationDir;
    private String mLocation;
    private String mDate;
    private String mUrl;

    public Earthquake(String magnitude, String dirLocation, String location,String date, String url){
        mMagnitude = magnitude;
        mLocationDir = dirLocation;
        mLocation = location;
        mDate = date;
        mUrl = url;


    }

    public String getMagnitude() {
        return mMagnitude;
    }
    public String getDirLocation() {
        return mLocationDir;
    }
    public String getLocation() {
        return mLocation;
    }
    public String getDate() {
        return mDate;
    }
    public String getURL() {return mUrl;}




}
