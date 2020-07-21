package com.android.example.tourguide;

public class TextItem {

    private String mFirstText;
    private String mSecondText;
    private String mLocation;
    //set valuue if no data is provided
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    // with 2 strings and 1 int
    public TextItem(String firstText, String secondText, int imageResourceId) {
        mFirstText = firstText;
        mSecondText = secondText;
        mImageResourceId = imageResourceId;
    }

    // with 3 strings and 1 int
    public TextItem(String firstText, String secondText, String location, int imageResourceId) {
        mFirstText = firstText;
        mSecondText = secondText;
        mLocation = location;
        mImageResourceId = imageResourceId;
    }

    // with 3 strings
    public TextItem(String firstText, String secondText, String location) {
        mFirstText = firstText;
        mSecondText = secondText;
        mLocation = location;
    }

    //only text
    public TextItem(String firstText, String secondText) {
        mFirstText = firstText;
        mSecondText = secondText;

    }

    public String getFirstText() {
        return mFirstText;
    }

    public String getSecondText() {
        return mSecondText;
    }

    public String getLocation() {
        return mLocation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}
