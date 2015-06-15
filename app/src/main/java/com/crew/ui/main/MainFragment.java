package com.crew.ui.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.crew.LoginActivity;
import com.crew.R;
import com.crew.ui.crew.UserDTO;
import com.crew.ui.material.FloatingActionButton;
import com.facebook.login.LoginManager;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static util.Server.MAIN_API;
import static util.Server.M_DOING;
import static util.Server.M_NOTICE;
import static util.Server.SERVER_ADDRESS;
import static util.Server.getStringFromUrl;

public class MainFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int position;
    private UserDTO userDTO;

    private RelativeLayout mMainLayout, mInfromationLayout, mAccountLayout;
    private CardView mInformationCloseButton, mAccountCloseButton;

    private ListView mTodoListView, mNoticeListView;
    private TodoListAdapter mTodoListAdapter;
    private NoticeListAdapter mNoticeAdapter;

    private Button facebookButton;

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

        userDTO = new UserDTO();

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

        mInformationCloseButton = (CardView) rootView.findViewById(R.id.informationCloseButton);
        mInformationCloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInfromationLayout.setVisibility(View.GONE);
                mMainLayout.setVisibility(View.VISIBLE);
            }
        });

        mAccountCloseButton = (CardView) rootView.findViewById(R.id.accountCloseButton);
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

        new getTodayDoing().execute(SERVER_ADDRESS + MAIN_API + M_DOING + userDTO.getId());

//        mTodoListAdapter.addItem("3:00 - 10:30", "Software Engineering");
//        mTodoListAdapter.addItem("12:00 - 13:00", "Meeting Somewhere");
//        mTodoListAdapter.addItem("15:00 - 17:00", "Crew Activity");
//        mTodoListAdapter.addItem("19:00 - 21:00", "Assignment");

        mNoticeAdapter = new NoticeListAdapter(getActivity());
        mNoticeListView = (ListView) rootView.findViewById(R.id.noticeListView);
        mNoticeListView.setAdapter(mNoticeAdapter);

        new getNotice().execute(SERVER_ADDRESS + MAIN_API + M_NOTICE + userDTO.getId());

//        mNoticeAdapter.addItem("My Prescience", "BigData Music Recommend...");
//        mNoticeAdapter.addItem("CCC", "Our Regular meeting...");
//        mNoticeAdapter.addItem("Hon-Cheon-Ui", "Next Meeting is on...");

        //facebook logout
        facebookButton = (Button) rootView.findViewById(R.id.facebookButton);
        facebookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

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

    class getTodayDoing extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... url) {
            String urlJSON = getStringFromUrl(url[0]);
            return urlJSON;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            JSONParser jsonParser = new JSONParser();
            JSONArray jsons = null;

            try {
                jsons = (JSONArray) jsonParser.parse(result);
                if(jsons != null) {
                    for(int i = 0; i < jsons.size(); i++) {
                        JSONObject timetable = (JSONObject) jsons.get(i);

                        String title = (String) timetable.get("title");
                        String start_time = (String) timetable.get("start_time");
                        String end_time = (String) timetable.get("end_time");

                        mTodoListAdapter.addItem(start_time + "-" + end_time, title);
                    }
                    mTodoListAdapter.notifyDataSetChanged();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }

    class getNotice extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... url) {
            String urlJSON = getStringFromUrl(url[0]);
            return urlJSON;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            JSONParser jsonParser = new JSONParser();
            JSONArray jsons = null;

            try {
                jsons = (JSONArray) jsonParser.parse(result);
                if(jsons != null) {
                    for(int i = 0; i < jsons.size(); i++) {
                        JSONObject timetable = (JSONObject) jsons.get(i);

                        String groups_name = (String) timetable.get("groups_name");
                        String message = (String) timetable.get("message");

                        mNoticeAdapter.addItem(groups_name, message);
                    }
                    mNoticeAdapter.notifyDataSetChanged();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }
}