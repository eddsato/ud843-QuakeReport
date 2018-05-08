package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

        Date dateObject = new Date(currentEarthquake.getmTimeInMilliseconds());

        TextView mDateTextView = (TextView) listItemView.findViewById(R.id.tv_date);
        String formattedDate = formatDate(dateObject);
        mDateTextView.setText(formattedDate);

        TextView mTimeTextView = (TextView) listItemView.findViewById(R.id.tv_time);
        String formattedTime = formatTime(dateObject);
        mTimeTextView.setText(formattedTime);

        return listItemView;
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime (Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
