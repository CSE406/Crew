package com.crew.ui.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crew.R;
import com.crew.ui.material.FloatingActionButton;

public class TimeTableFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private int position;

    private String[] title = new String[50];
    private int[] date = new int[50];
    private int[] startTime = new int[50];
    private int[] endTime = new int[50];
    private String[] location = new String[50];
    private String[] memo = new String[50];

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

            FloatingActionButton addition = (FloatingActionButton) rootView.findViewById(R.id.AdditionButton);
            addition.setDrawableIcon(getResources().getDrawable(R.drawable.plus));



            addition.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch(v.getId())
                    {
                        case R.id.AdditionButton :
                            Intent intent = new Intent(getActivity(), MidOptionActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);


                            break;
                    }
                }
            });

            return rootView;
        }
}
