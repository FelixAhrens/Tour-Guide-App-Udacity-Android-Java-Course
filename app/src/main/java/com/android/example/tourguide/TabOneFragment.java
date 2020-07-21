package com.android.example.tourguide;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class TabOneFragment extends Fragment {

    public TabOneFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        //Create list_view_item of textItems with own TextItem class -> TextItem.java
        final ArrayList<TextItem> textItems = new ArrayList<TextItem>();
        textItems.add(new TextItem(getString(R.string.landung),
                getString(R.string.landung_detail),
                getString(R.string.geotag_landung),
                R.drawable.landungsbr_cken));
        textItems.add(new TextItem(getString(R.string.elbtunnel),
                getString(R.string.elbtunnel_detail),
                getString(R.string.geotag_elbtunnel),
                R.drawable.elbtunnel));
        textItems.add(new TextItem(getString(R.string.warehouse),
                getString(R.string.warehouse_detail),
                getString(R.string.geotag_warehouse),
                R.drawable.speicherstadt));
        textItems.add(new TextItem(getString(R.string.michel),
                getString(R.string.michel_detail),
                getString(R.string.geotag_michel),
                R.drawable.michel));
        textItems.add(new TextItem(getString(R.string.fishmarket),
                getString(R.string.fishmarket_detail),
                getString(R.string.geotag_fishmarket),
                R.drawable.fischmarkt));
        textItems.add(new TextItem(getString(R.string.alster),
                getString(R.string.alster_detail),
                getString(R.string.geotag_alster),
                R.drawable.alster));
        textItems.add(new TextItem(getString(R.string.elbebeach),
                getString(R.string.elbebeach_detail),
                getString(R.string.geotag_elbebeach),
                R.drawable.elbstrand));

        TextItemAdapter adapter = new TextItemAdapter(getActivity(), textItems, R.color.list_item_background_colors);

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        //Intent for maps
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                String location = textItems.get(position).getLocation();

                Uri gmmIntentUri = Uri.parse(location);
                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                startActivity(mapIntent);
            }
        });

        return rootView;
    }

}
