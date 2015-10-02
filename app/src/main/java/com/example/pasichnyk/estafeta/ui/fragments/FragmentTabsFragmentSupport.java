package com.example.pasichnyk.estafeta.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pasichnyk.estafeta.R;
import com.example.pasichnyk.estafeta.ui.adapters.TabsFragmentAdapter;
import com.viewpagerindicator.TabPageIndicator;


public class FragmentTabsFragmentSupport extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_with_tabs, container, false);
        ViewPager pager = (ViewPager) rootview.findViewById(R.id.viewpager);
        PagerAdapter adapter = new TabsFragmentAdapter(getActivity().getSupportFragmentManager(), getArguments());
        pager.setAdapter(adapter);

        TabPageIndicator mIndicator = (TabPageIndicator) rootview.findViewById(R.id.viewpagerIndicator);
        mIndicator.setViewPager(pager);
        mIndicator.setBackgroundColor(getActivity().getResources().getColor(R.color.actionbar_color));
        mIndicator.setDrawingCacheBackgroundColor(getActivity().getResources().getColor(R.color.actionbar_color));

        return rootview;
    }
}