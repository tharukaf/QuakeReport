package com.example.android.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    String tempMagnitude;

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes){
        super(context,0,earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemVIew = convertView;
        if(listItemVIew == null){
            listItemVIew = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item,parent,false);
        }
        Earthquake currentEarthquake = getItem(position);
        TextView magnitudeView = (TextView) listItemVIew.findViewById(R.id.magnitude);
        magnitudeView.setText(currentEarthquake.getMagnitude());
        tempMagnitude = currentEarthquake.getMagnitude();

        int tempColor = selectColor();
        Log.i("color value", Integer.toString(tempColor));
        magnitudeView.setBackgroundColor(tempColor);

        TextView locationDirView = (TextView) listItemVIew.findViewById(R.id.dirlocation);
        locationDirView.setText(currentEarthquake.getDirLocation());

        TextView locationView = (TextView) listItemVIew.findViewById(R.id.location);
        locationView.setText(currentEarthquake.getLocation());

        TextView dateView = (TextView) listItemVIew.findViewById(R.id.date);
        dateView.setText(currentEarthquake.getDate());


        return listItemVIew;
    }


    //Method to select the color for magnitude
    public int selectColor() {
        double tempMag = Double.parseDouble(tempMagnitude);

        int tempInt = (int) Math.floor(tempMag);
        Log.i("tempInt", Integer.toString(tempInt));
        int colorID = 0;

        switch (tempInt){
            case 1: colorID =  ContextCompat.getColor(getContext(), R.color.magnitude1) ; break;
            case 2: colorID =  ContextCompat.getColor(getContext(), R.color.magnitude2) ; break;
            case 3: colorID =  ContextCompat.getColor(getContext(), R.color.magnitude3) ; break;
            case 4: colorID =  ContextCompat.getColor(getContext(), R.color.magnitude4) ; break;
            case 5: colorID =  ContextCompat.getColor(getContext(), R.color.magnitude5) ; break;
            case 6: colorID =  ContextCompat.getColor(getContext(), R.color.magnitude6) ; break;
            case 7: colorID =  ContextCompat.getColor(getContext(), R.color.magnitude7) ; break;
            case 8: colorID =  ContextCompat.getColor(getContext(), R.color.magnitude8) ; break;
            case 9: colorID =  ContextCompat.getColor(getContext(), R.color.magnitude9) ; break;
            default: colorID = ContextCompat.getColor(getContext(), R.color.magnitude10plus) ; break;

        }
        return colorID; }


}

