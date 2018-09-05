package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import static java.lang.Float.parseFloat;


public class EarthquakeAdapter extends ArrayAdapter {

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context,0,earthquakes);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item,parent,false);
        }

        Earthquake currentEarthquake = (Earthquake) getItem(position);

        DecimalFormat d = new DecimalFormat("#.#"); //Decimal formatter to format the the magnitude in #.# format
        d.setRoundingMode(RoundingMode.HALF_EVEN);  // setting the rounding mode to HALF.EVEN


        //Getting the magnitude of the current instance and assigning it to a float variable
        Float f = Float.parseFloat(currentEarthquake.getmEarthquakeMagnitude());

        //using variable f and formatter d to format the original magnitude value
        Float g = Float.parseFloat(d.format(f));


        /*
        * Creating TextViews and setting their values to the current instance of the earthquake
        *
        * */

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.textViewMagnitude);
        magnitudeView.setText(g.toString());

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = ContextCompat.getColor(getContext(),Utils.colorPicker(f));

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);
       // magnitudeView.setBackgroundColor(ContextCompat.getColor(getContext(),Utils.colorPicker(f)));

        TextView relativeLocationView = (TextView) listItemView.findViewById(R.id.textViewRelativeLocation);
        relativeLocationView.setText(Utils.relativeLocationFormatter(currentEarthquake.getmEarthquakeLocation()));

        TextView locationView = (TextView) listItemView.findViewById(R.id.textViewLocation);
        locationView.setText(Utils.exactLocationFormatter(currentEarthquake.getmEarthquakeLocation()).trim());

        TextView dateView = (TextView) listItemView.findViewById(R.id.textViewDate);
        dateView.setText(Utils.dateFormatter(currentEarthquake.getmEarthquakeDate()));

        TextView timeView = (TextView) listItemView.findViewById(R.id.textViewTime);
        timeView.setText(Utils.timeFormatter(currentEarthquake.getmEarthquakeDate()));


        return listItemView;
    }




}


