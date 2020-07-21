package com.android.example.tourguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class TextItemAdapter extends ArrayAdapter<TextItem> {
    //from https://github.com/udacity/ud839_CustomAdapter_Example/blob/master/app/src/main/java/com/example/android/flavor/AndroidFlavorAdapter.java

    private static final String LOG_TAG = TextItemAdapter.class.getSimpleName();

    // Background color
    private int mColor;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list_view_item is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param textItems         A List of textItems objects to display in a list_view_item
     */
    public TextItemAdapter(Activity context, ArrayList<TextItem> textItems, int colorBack) {
        // Here, we initialize the TextItem internal storage for the context and the list_view_item.
        // the second argument is used when the TextItem is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, textItems);
        mColor = colorBack;
    }
    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list_view_item of data that should be displayed in the
     *                 list_view_item item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View textItemView = convertView;
        if(textItemView == null) {
            textItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_text_items, parent, false);
        }
        //backgroundcolor
        View colorView = textItemView.findViewById(R.id.list_text_items);
        int color = ContextCompat.getColor(getContext(), mColor);
        colorView.setBackgroundColor(color);

        // Get the {@link Word} object located at this position in the list_view_item
        TextItem currentTextItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView firstTextView = (TextView) textItemView.findViewById(R.id.first_item);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        firstTextView.setText(currentTextItem.getFirstText());
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView secondTextView = (TextView) textItemView.findViewById(R.id.second_item);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        secondTextView.setText(currentTextItem.getSecondText());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) textItemView.findViewById(R.id.image);

        // if no image in the array list_view_item hide the imageview
        if (currentTextItem.hasImage()) {
            // Get the image resource ID from the current Word object and
            // set the image to iconView
            iconView.setImageResource(currentTextItem.getImageResourceId());
        } else { iconView.setVisibility(View.GONE);}
        // Return the whole list_view_item item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView

        return textItemView;

    }
}
