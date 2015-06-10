package com.crew.ui.crew;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.crew.R;

public class CrewFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int position;

    private RelativeLayout mCrewLayout, mAddCrewLayout;
    private ListView mCrewListView, mTodayListView;
    private CrewListAdapter mCrewListAdapter;
    private TodayListAdapter mTodayListAdapter;
    private Button mAddCrewButton, mSaveButton, mCancelButton;

    public static CrewFragment newInstance(int position) {
        CrewFragment f = new CrewFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        position = getArguments().getInt(ARG_POSITION);
        View rootView = inflater.inflate(R.layout.fragment_crew, container, false);

        mCrewLayout = (RelativeLayout) rootView.findViewById(R.id.crewLayout);
        mAddCrewLayout = (RelativeLayout) rootView.findViewById(R.id.addCrewLayout);

        mAddCrewButton = (Button) rootView.findViewById(R.id.addCrewButton);
        mAddCrewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCrewLayout.setVisibility(View.GONE);
                mAddCrewLayout.setVisibility(View.VISIBLE);
            }
        });

        mSaveButton = (Button) rootView.findViewById(R.id.saveCrewButton);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Save", "새로운 크루 저장.");
            }
        });

        mCancelButton = (Button) rootView.findViewById(R.id.cancelCrewButton);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddCrewLayout.setVisibility(View.GONE);
                mCrewLayout.setVisibility(View.VISIBLE);
            }
        });

        mCrewListAdapter = new CrewListAdapter(getActivity());
        mCrewListView = (ListView) rootView.findViewById(R.id.crewListView);
        mCrewListView.setAdapter(mCrewListAdapter);

        mCrewListAdapter.addItem("DIV", "Crew Name");
        mCrewListAdapter.addItem("Club", "CCC");
        mCrewListAdapter.addItem("Team", "Hon-Cheon-Ui");
        mCrewListAdapter.addItem("Class", "Software Engineering Class");
        mCrewListAdapter.addItem("Team", "Meeting Group");

        mTodayListAdapter = new TodayListAdapter(getActivity());
        mTodayListView = (ListView) rootView.findViewById(R.id.crewTodayListView);
        mTodayListView.setAdapter(mTodayListAdapter);

        mTodayListAdapter.addItem("TIME", "Location", "Contents");
        mTodayListAdapter.addItem("10:30", "Y05-301", "Our Regular Meeting..");
        mTodayListAdapter.addItem("12:00", "Y05-301", "Next Meeting is on..");
        mTodayListAdapter.addItem("3:00", "Andante", "Special Party");

        return rootView;
    }
}