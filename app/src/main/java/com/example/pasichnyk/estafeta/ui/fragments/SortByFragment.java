package com.example.pasichnyk.estafeta.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.pasichnyk.estafeta.R;


public class SortByFragment extends Fragment {

    ListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.screen_one, container, false);
        listView = (ListView) getActivity().findViewById(R.id.list_first_fragment);

        return rootView;
    }
}
