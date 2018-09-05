/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    private static final int EARTHQUAKE_LOADER_ID = 1;
    private EarthquakeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);
        changeHeader();

        ListView earthquakeListView = (ListView) findViewById(R.id.list); // Find a reference to the {@link ListView} in the layout
        adapter = new EarthquakeAdapter(this, new ArrayList<Earthquake>());
        earthquakeListView.setAdapter(adapter); // Set the adapter on the {@link ListView}  // so the list can be populated in the user interface// Create a new {@link ArrayAdapter} of earthquakes

        EarthquakeAsyncTask task = new EarthquakeAsyncTask();  //Implementing using a regular async task
        task.execute(Utils.getUsgsUrl());

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Earthquake currentEarthquake = (Earthquake) adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getmUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }



    public void changeHeader(){   //Method to change app header: called in the onCreate method

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_header_item);

    }


    private class EarthquakeAsyncTask extends AsyncTask<String, Void, ArrayList<Earthquake>> {   //Way to do it using an Async task

        @Override
        protected ArrayList<Earthquake> doInBackground(String... strings) {

            ArrayList<Earthquake> result = Utils.fetchEarthquakeDate(strings[0]);
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Earthquake> earthquakes) {
            super.onPostExecute(earthquakes);

            if(earthquakes != null && !earthquakes.isEmpty()) {
                adapter.addAll(earthquakes);
            }
        }
    }
}
