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

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    private static final String URL = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        FetchData task = new FetchData();
        task.execute(URL);

//        // Create a fake list of earthquake locations.
//        final ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();
//
//        // Find a reference to the {@link ListView} in the layout
//        ListView earthquakeListView = (ListView) findViewById(R.id.list);
//
//        // Create a new {@link ArrayAdapter} of earthquakes
//        final EarthquakeAdapter itemsAdapter = new EarthquakeAdapter(this, earthquakes);
//
//        // Set the adapter on the {@link ListView}
//        // so the list can be populated in the user interface
//        earthquakeListView.setAdapter(itemsAdapter);
//
//        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Earthquake earthquake = itemsAdapter.getItem(position);
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse(earthquake.getmUrl()));
//                startActivity(intent);
//            }
//        });
    }

    private class FetchData extends AsyncTask<String, Void, List<Earthquake>>{

        @Override
        protected List<Earthquake> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null){
                return null;
            }

            ArrayList<Earthquake> result = QueryUtils.fetchEarthquakeData(urls[0]);

            Log.v(LOG_TAG, "RETORNO: " + result);

            return result;
        }

        @Override
        protected void onPostExecute(List<Earthquake> result) {
            //updateUi(result);
        }
    }
}