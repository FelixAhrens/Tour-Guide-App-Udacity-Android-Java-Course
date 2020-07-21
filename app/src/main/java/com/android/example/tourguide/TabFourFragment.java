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

public class TabFourFragment extends Fragment {

    public TabFourFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        //Create list_view_item of textItems with own TextItem class -> TextItem.java
        final ArrayList<TextItem> textItems = new ArrayList<TextItem>();
        textItems.add(new TextItem(getString(R.string.reeperbahn), getString(R.string.reeperbahn_detail),
                getString(R.string.geotag_reeperbahn),
                R.drawable.reeperbahn));
        textItems.add(new TextItem(getString(R.string.sternschanze), getString(R.string.sternschanze_detail),
                getString(R.string.geotag_sternschanze),
                R.drawable.sternschanze));
        textItems.add(new TextItem(getString(R.string.boilerman), getString(R.string.boilerman_detail),
                getString(R.string.geotag_boilerman),
                R.drawable.boilerman));

        TextItemAdapter adapter = new TextItemAdapter(getActivity(), textItems, R.color.list_item_background_colors);

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);

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
