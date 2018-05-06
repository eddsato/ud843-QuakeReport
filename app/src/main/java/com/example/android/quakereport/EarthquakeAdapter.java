package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView mMagnitudeTextView = (TextView) listItemView.findViewById(R.id.tv_magnitude);
        mMagnitudeTextView.setText(currentEarthquake.getmMagnitude());

        TextView mLocationTextView = (TextView) listItemView.findViewById(R.id.tv_location);
        mLocationTextView.setText(currentEarthquake.getmLocation());

        TextView mDateTextView = (TextView) listItemView.findViewById(R.id.tv_date);
        mDateTextView.setText(currentEarthquake.getmDate());

        return listItemView;
    }
}
