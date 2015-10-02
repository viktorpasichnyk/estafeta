package com.example.pasichnyk.estafeta.ui.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.pasichnyk.estafeta.ui.fragments.InformationFragment;
import com.example.pasichnyk.estafeta.ui.fragments.SortByFragment;

public class TabsFragmentAdapter extends FragmentPagerAdapter {
    public static final String[] CONTENT = new String[]{"INFORMATION", "SURVEY CONDITION", "PHOTOS", "MAP"};
    private int mCount = CONTENT.length;
    Bundle bundle;

    public TabsFragmentAdapter(FragmentManager fm, Bundle bundle) {
        super(fm);
        this.bundle = bundle;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position % CONTENT.length) {
            case 0:
                InformationFragment informationFragment = new InformationFragment();
                informationFragment.setArguments(bundle);
                return informationFragment;
//                return new InformationFragment();

        }
        return new SortByFragment();
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {


        return TabsFragmentAdapter.CONTENT[position % CONTENT.length];
    }


    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}


