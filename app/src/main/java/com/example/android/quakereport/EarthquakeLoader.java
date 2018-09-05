package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.ArrayList;


public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {

    String globalURL;

    public EarthquakeLoader(Context context, String url) {
        super(context);
        globalURL = url;
    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {
        ArrayList<Earthquake> result = Utils.fetchEarthquakeDate(globalURL);
        return result;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}
