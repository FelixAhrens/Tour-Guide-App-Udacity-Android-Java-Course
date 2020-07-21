package com.android.example.tourguide;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class TabTwoFragment extends Fragment {

    public TabTwoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_view, container, false);

        //Create list_view_item of textItems with own TextItem class -> TextItem.java
        final ArrayList<TextItem> textItems = new ArrayList<TextItem>();
        textItems.add(new TextItem(getString(R.string.events), getString(R.string.events_detail)));

        TextItemAdapter adapter = new TextItemAdapter(getActivity(), textItems, R.color.list_item_background_colors);

        ListView listView = (ListView) rootView.findViewById(R.id.list_view);
        listView.setAdapter(adapter);


        return rootView;
    }

}
