package com.crew.ui.group;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.crew.R;

public class MainFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private int position;

    private ListView groupListView;
    private GroupListAdapter groupListAdapter;

    public static MainFragment newInstance(int position) {
        MainFragment f = new MainFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        position = getArguments().getInt(ARG_POSITION);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

//        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fabButton);
//        fab.setDrawableIcon(getResources().getDrawable(R.drawable.plus));
//        fab.setBackgroundColor(getResources().getColor(R.color.purple_500));

//        groupListAdapter = new GroupListAdapter(getActivity());
//        groupListView = (ListView) rootView.findViewById(R.id.songListView);
//        groupListView.setAdapter(groupListAdapter);
//
//        groupListAdapter.addItem("test", "test", "test", "test", "test", 0);
//        groupListAdapter.addItem("test", "test", "test", "test", "test", 0);
//        groupListAdapter.addItem("test", "test", "test", "test", "test", 0);
//        groupListAdapter.addItem("test", "test", "test", "test", "test", 0);
//        groupListAdapter.addItem("test", "test", "test", "test", "test", 0);
//        groupListAdapter.addItem("test", "test", "test", "test", "test", 0);
//        groupListAdapter.addItem("test", "test", "test", "test", "test", 0);
//        groupListAdapter.addItem("test", "test", "test", "test", "test", 0);
//        groupListAdapter.addItem("test", "test", "test", "test", "test", 0);

        return rootView;
    }
}