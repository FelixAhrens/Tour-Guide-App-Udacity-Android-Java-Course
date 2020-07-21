package com.android.example.tourguide;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class OwnFragmentPagerAdapter extends FragmentPagerAdapter {

    //set fragments names
    private String[] tabTitles = new String[]{"Sightseeing", "Events", "Restaurants", "Evening"};

    public OwnFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // overriding getPageTitle()
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    //return position of fragments
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new TabOneFragment();
        } else if (position == 1){
            return new TabTwoFragment();
        } else if (position == 2){
            return new TabThreeFragment();
        } else {
            return new TabFourFragment();
        }

    }

    // count of fragments
    @Override
    public int getCount() {
        return 4;
    }
}
