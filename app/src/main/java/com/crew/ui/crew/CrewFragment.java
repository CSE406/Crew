package com.crew.ui.crew;

import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.crew.R;
import com.crew.ui.material.FloatingActionButton;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static util.Server.CREW_API;
import static util.Server.CREW_MAIN;
import static util.Server.SERVER_ADDRESS;
import static util.Server.getStringFromUrl;

public class CrewFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int position;
    private UserDTO userDTO;

    private RelativeLayout mCrewLayout, mAddCrewLayout;
    private ListView mCrewListView;
    private CrewListAdapter mCrewListAdapter;
    private CardView mSaveButton, mCancelButton;
    private TextView mCrewBrandTextView;

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

        userDTO = new UserDTO();

        mCrewLayout = (RelativeLayout) rootView.findViewById(R.id.crewLayout);
        mAddCrewLayout = (RelativeLayout) rootView.findViewById(R.id.addCrewLayout);

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.addCrewButton);
        fab.setDrawableIcon(getResources().getDrawable(R.drawable.button_plus));
        fab.setBackgroundColor(getResources().getColor(R.color.purple_500));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCrewLayout.setVisibility(View.GONE);
                mAddCrewLayout.setVisibility(View.VISIBLE);
            }
        });

        mSaveButton = (CardView) rootView.findViewById(R.id.saveCrewButton);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Save", "새로운 크루 저장.");
            }
        });

        mCancelButton = (CardView) rootView.findViewById(R.id.cancelCrewButton);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddCrewLayout.setVisibility(View.GONE);
                mCrewLayout.setVisibility(View.VISIBLE);
            }
        });

        mCrewBrandTextView = (TextView) rootView.findViewById(R.id.crewTextView);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "toms_handwritten.ttf");
        mCrewBrandTextView.setTypeface(font);

        mCrewListAdapter = new CrewListAdapter(getActivity());
        mCrewListView = (ListView) rootView.findViewById(R.id.crewListView);
        mCrewListView.setAdapter(mCrewListAdapter);

        new getCrewList().execute(SERVER_ADDRESS + CREW_API + CREW_MAIN + userDTO.getId());

//        mCrewListAdapter.addItem("Club", "CCC");
//        mCrewListAdapter.addItem("Team", "Hon-Cheon-Ui");
//        mCrewListAdapter.addItem("Class", "Software Engineering Class");
//        mCrewListAdapter.addItem("Team", "Meeting Group");

        return rootView;
    }

    class getCrewList extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... url) {
            String urlJSON = getStringFromUrl(url[0]);
            return urlJSON;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            Log.e("result", result);
            JSONParser jsonParser = new JSONParser();
            JSONArray jsons = null;

            try {
                jsons = (JSONArray) jsonParser.parse(result);
                if(jsons != null) {
                    for(int i = 0; i < jsons.size(); i++) {
                        JSONObject timetable = (JSONObject) jsons.get(i);

                        int id = Integer.parseInt((String) timetable.get("id"));
                        String name = (String) timetable.get("name");
                        String label = (String) timetable.get("label");

                        mCrewListAdapter.addItem(id, label, name);
                    }
                    mCrewListAdapter.notifyDataSetChanged();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }
}