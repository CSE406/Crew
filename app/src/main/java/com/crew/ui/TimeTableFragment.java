package com.crew.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crew.R;
import com.crew.ui.material.FloatingActionButton;
import com.crew.ui.material.ProgressBarCircular;

public class TimeTableFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private int position;

    public static TimeTableFragment newInstance(int position) {
        TimeTableFragment f = new TimeTableFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        position = getArguments().getInt(ARG_POSITION);
        View rootView = inflater.inflate(R.layout.fragment_time_table, container, false);

        return rootView;
    }
}