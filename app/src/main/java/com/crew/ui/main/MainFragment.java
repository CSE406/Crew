package com.crew.ui.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.crew.R;
import com.crew.ui.material.FloatingActionButton;

public class MainFragment extends Fragment {

    private static final String ARG_POSITION = "position";

    private int position;

    private RelativeLayout mMainLayout, mInfromationLayout, mAccountLayout;
    private Button mInformationCloseButton, mAccountCloseButton;

    private ListView mTodoListView, mNoticeListView;
    private TodoListAdapter mTodoListAdapter;
    private NoticeListAdapter mNoticeAdapter;

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

        mMainLayout = (RelativeLayout) rootView.findViewById(R.id.mainLayout);
        mInfromationLayout = (RelativeLayout) rootView.findViewById(R.id.informationLayout);
        mAccountLayout = (RelativeLayout) rootView.findViewById(R.id.accountLayout);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.mainMenuButton);
        fab.setDrawableIcon(getResources().getDrawable(R.drawable.button_icon));
        fab.setBackgroundColor(getResources().getColor(R.color.purple_500));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogRadio();
            }
        });

        mInformationCloseButton = (Button) rootView.findViewById(R.id.informationCloseButton);
        mInformationCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInfromationLayout.setVisibility(View.GONE);
                mMainLayout.setVisibility(View.VISIBLE);
            }
        });

        mAccountCloseButton = (Button) rootView.findViewById(R.id.accountCloseButton);
        mAccountCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAccountLayout.setVisibility(View.GONE);
                mMainLayout.setVisibility(View.VISIBLE);
            }
        });

        mTodoListAdapter = new TodoListAdapter(getActivity());
        mTodoListView = (ListView) rootView.findViewById(R.id.todoListView);
        mTodoListView.setAdapter(mTodoListAdapter);

        mTodoListAdapter.addItem("Time", "Doing");
        mTodoListAdapter.addItem("3:00 - 10:30", "Software Engineering");
        mTodoListAdapter.addItem("12:00 - 13:00", "Meeting Somewhere");
        mTodoListAdapter.addItem("15:00 - 17:00", "Crew Activity");

        mNoticeAdapter = new NoticeListAdapter(getActivity());
        mNoticeListView = (ListView) rootView.findViewById(R.id.noticeListView);
        mNoticeListView.setAdapter(mNoticeAdapter);

        mNoticeAdapter.addItem("Crew Names", "Contents");
        mNoticeAdapter.addItem("CCC", "Our Regular meeting...");
        mNoticeAdapter.addItem("Hon-Cheon-Ui", "Next Meeting is on...");

        return rootView;
    }

    private void DialogRadio(){
        final CharSequence[] mainMenu = {"Information", "Accounts"};
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(getActivity());
        alt_bld.setIcon(R.drawable.icon_logo2_small);
        alt_bld.setTitle("Select Menu!");
        alt_bld.setItems(mainMenu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (mainMenu[item] == mainMenu[0]) {
                    mMainLayout.setVisibility(View.GONE);
                    mInfromationLayout.setVisibility(View.VISIBLE);
                } else if (mainMenu[item] == mainMenu[1]) {
                    mMainLayout.setVisibility(View.GONE);
                    mAccountLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        AlertDialog alert = alt_bld.create();
        alert.show();
    }
}