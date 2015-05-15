package com.crew.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crew.R;
import com.crew.ui.material.FloatingActionButton;
import com.crew.ui.material.ProgressBarCircular;

public class GroupListFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private int position;

    public static GroupListFragment newInstance(int position) {
        GroupListFragment f = new GroupListFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        position = getArguments().getInt(ARG_POSITION);
        View rootView = inflater.inflate(R.layout.fragment_grouplist, container, false);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabButton);
        fab.setDrawableIcon(getResources().getDrawable(R.drawable.plus));

        return rootView;
    }
}