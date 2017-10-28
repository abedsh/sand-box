package com.codefish.sandbox;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/23/2016.
 */
public class TutorialAdapter extends FragmentPagerAdapter {

    List<String> titles;
    List<TourPageFragment> fragments;
    private Context context;

    int[] mImages = new int[]{
            R.drawable.tutorial_1,
            R.drawable.tutorial_2,
            R.drawable.tutorial_3};


    public TutorialAdapter(FragmentManager fm, Context c) {
        super(fm);
        this.context = c;


        fragments = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            TourPageFragment fragment = TourPageFragment.newInstance(mImages[i]);
            fragments.add(fragment);
        }
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return TourPageFragment.newInstance(R.drawable.tutorial_hd1);
            case 1:
                return TourPageFragment.newInstance(R.drawable.tutorial_hd2);
            case 2:
                return TourPageFragment.newInstance(R.drawable.tutorial_hd3);
            default:
        }

        return TourPageFragment.newInstance(mImages[0]);

    }

    @Override
    public int getCount() {
        return 3;
    }
}
