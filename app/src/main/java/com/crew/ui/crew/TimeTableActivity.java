package com.crew.ui.crew;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.crew.R;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Random;

import static util.Server.CALL_ALL;
import static util.Server.CREW_API;
import static util.Server.SCHEDULE;
import static util.Server.SERVER_ADDRESS;
import static util.Server.getStringFromUrl;

public class TimeTableActivity extends ActionBarActivity {

    private Button[][] d;
    private int col[] = {0xfffff61a, 0xff6cff13, 0xffffc810, 0xff77f5ff, 0xffceff23, 0xffffa184, 0xffff2fa5, 0xff60a0ff, 0xfffff7e5, 0xffffbcda, 0xffc4afff, 0xff58ffc6, 0xffe0ffb1, 0xffffcae5};
    private int colorIndex;

    private int GROUP_ID;
    private boolean start = false;

    private String start_time = "", end_time = "", day_of_week = "", title = "", memo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        GROUP_ID = (int) getIntent().getExtras().get("group_id");
        init();

        new getTimeTable().execute(SERVER_ADDRESS + CREW_API + SCHEDULE + CALL_ALL + GROUP_ID);
        Log.e("URL", SERVER_ADDRESS + CREW_API + SCHEDULE + CALL_ALL + GROUP_ID);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_time_table, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void init() {

        d = new Button[5][27];

        d[0][1] = (Button)findViewById(R.id.mondayButton1);
        d[0][2] = (Button)findViewById(R.id.mondayButton2);
        d[0][3] = (Button)findViewById(R.id.mondayButton3);
        d[0][4] = (Button)findViewById(R.id.mondayButton4);
        d[0][5] = (Button)findViewById(R.id.mondayButton5);
        d[0][6] = (Button)findViewById(R.id.mondayButton6);
        d[0][7] = (Button)findViewById(R.id.mondayButton7);
        d[0][8] = (Button)findViewById(R.id.mondayButton8);
        d[0][9] = (Button)findViewById(R.id.mondayButton9);
        d[0][10] = (Button)findViewById(R.id.mondayButton10);
        d[0][11] = (Button)findViewById(R.id.mondayButton11);
        d[0][12] = (Button)findViewById(R.id.mondayButton12);
        d[0][13] = (Button)findViewById(R.id.mondayButton13);
        d[0][14] = (Button)findViewById(R.id.mondayButton14);
        d[0][15] = (Button)findViewById(R.id.mondayButton15);
        d[0][16] = (Button)findViewById(R.id.mondayButton16);
        d[0][17] = (Button)findViewById(R.id.mondayButton17);
        d[0][18] = (Button)findViewById(R.id.mondayButton18);
        d[0][19] = (Button)findViewById(R.id.mondayButton19);
        d[0][20] = (Button)findViewById(R.id.mondayButton20);
        d[0][21] = (Button)findViewById(R.id.mondayButton21);
        d[0][22] = (Button)findViewById(R.id.mondayButton22);
        d[0][23] = (Button)findViewById(R.id.mondayButton23);
        d[0][24] = (Button)findViewById(R.id.mondayButton24);
        d[0][25] = (Button)findViewById(R.id.mondayButton25);
        d[0][26] = (Button)findViewById(R.id.mondayButton26);

        d[1][1] = (Button)findViewById(R.id.tuesdayButton1);
        d[1][2] = (Button)findViewById(R.id.tuesdayButton2);
        d[1][3] = (Button)findViewById(R.id.tuesdayButton3);
        d[1][4] = (Button)findViewById(R.id.tuesdayButton4);
        d[1][5] = (Button)findViewById(R.id.tuesdayButton5);
        d[1][6] = (Button)findViewById(R.id.tuesdayButton6);
        d[1][7] = (Button)findViewById(R.id.tuesdayButton7);
        d[1][8] = (Button)findViewById(R.id.tuesdayButton8);
        d[1][9] = (Button)findViewById(R.id.tuesdayButton9);
        d[1][10] = (Button)findViewById(R.id.tuesdayButton10);
        d[1][11] = (Button)findViewById(R.id.tuesdayButton11);
        d[1][12] = (Button)findViewById(R.id.tuesdayButton12);
        d[1][13] = (Button)findViewById(R.id.tuesdayButton13);
        d[1][14] = (Button)findViewById(R.id.tuesdayButton14);
        d[1][15] = (Button)findViewById(R.id.tuesdayButton15);
        d[1][16] = (Button)findViewById(R.id.tuesdayButton16);
        d[1][17] = (Button)findViewById(R.id.tuesdayButton17);
        d[1][18] = (Button)findViewById(R.id.tuesdayButton18);
        d[1][19] = (Button)findViewById(R.id.tuesdayButton19);
        d[1][20] = (Button)findViewById(R.id.tuesdayButton20);
        d[1][21] = (Button)findViewById(R.id.tuesdayButton21);
        d[1][22] = (Button)findViewById(R.id.tuesdayButton22);
        d[1][23] = (Button)findViewById(R.id.tuesdayButton23);
        d[1][24] = (Button)findViewById(R.id.tuesdayButton24);
        d[1][25] = (Button)findViewById(R.id.tuesdayButton25);
        d[1][26] = (Button)findViewById(R.id.tuesdayButton26);

        d[2][1] = (Button)findViewById(R.id.wednesdayButton1);
        d[2][2] = (Button)findViewById(R.id.wednesdayButton2);
        d[2][3] = (Button)findViewById(R.id.wednesdayButton3);
        d[2][4] = (Button)findViewById(R.id.wednesdayButton4);
        d[2][5] = (Button)findViewById(R.id.wednesdayButton5);
        d[2][6] = (Button)findViewById(R.id.wednesdayButton6);
        d[2][7] = (Button)findViewById(R.id.wednesdayButton7);
        d[2][8] = (Button)findViewById(R.id.wednesdayButton8);
        d[2][9] = (Button)findViewById(R.id.wednesdayButton9);
        d[2][10] = (Button)findViewById(R.id.wednesdayButton10);
        d[2][11] = (Button)findViewById(R.id.wednesdayButton11);
        d[2][12] = (Button)findViewById(R.id.wednesdayButton12);
        d[2][13] = (Button)findViewById(R.id.wednesdayButton13);
        d[2][14] = (Button)findViewById(R.id.wednesdayButton14);
        d[2][15] = (Button)findViewById(R.id.wednesdayButton15);
        d[2][16] = (Button)findViewById(R.id.wednesdayButton16);
        d[2][17] = (Button)findViewById(R.id.wednesdayButton17);
        d[2][18] = (Button)findViewById(R.id.wednesdayButton18);
        d[2][19] = (Button)findViewById(R.id.wednesdayButton19);
        d[2][20] = (Button)findViewById(R.id.wednesdayButton20);
        d[2][21] = (Button)findViewById(R.id.wednesdayButton21);
        d[2][22] = (Button)findViewById(R.id.wednesdayButton22);
        d[2][23] = (Button)findViewById(R.id.wednesdayButton23);
        d[2][24] = (Button)findViewById(R.id.wednesdayButton24);
        d[2][25] = (Button)findViewById(R.id.wednesdayButton25);
        d[2][26] = (Button)findViewById(R.id.wednesdayButton26);

        d[3][1] = (Button)findViewById(R.id.thursdayButton1);
        d[3][2] = (Button)findViewById(R.id.thursdayButton2);
        d[3][3] = (Button)findViewById(R.id.thursdayButton3);
        d[3][4] = (Button)findViewById(R.id.thursdayButton4);
        d[3][5] = (Button)findViewById(R.id.thursdayButton5);
        d[3][6] = (Button)findViewById(R.id.thursdayButton6);
        d[3][7] = (Button)findViewById(R.id.thursdayButton7);
        d[3][8] = (Button)findViewById(R.id.thursdayButton8);
        d[3][9] = (Button)findViewById(R.id.thursdayButton9);
        d[3][10] = (Button)findViewById(R.id.thursdayButton10);
        d[3][11] = (Button)findViewById(R.id.thursdayButton11);
        d[3][12] = (Button)findViewById(R.id.thursdayButton12);
        d[3][13] = (Button)findViewById(R.id.thursdayButton13);
        d[3][14] = (Button)findViewById(R.id.thursdayButton14);
        d[3][15] = (Button)findViewById(R.id.thursdayButton15);
        d[3][16] = (Button)findViewById(R.id.thursdayButton16);
        d[3][17] = (Button)findViewById(R.id.thursdayButton17);
        d[3][18] = (Button)findViewById(R.id.thursdayButton18);
        d[3][19] = (Button)findViewById(R.id.thursdayButton19);
        d[3][20] = (Button)findViewById(R.id.thursdayButton20);
        d[3][21] = (Button)findViewById(R.id.thursdayButton21);
        d[3][22] = (Button)findViewById(R.id.thursdayButton22);
        d[3][23] = (Button)findViewById(R.id.thursdayButton23);
        d[3][24] = (Button)findViewById(R.id.thursdayButton24);
        d[3][25] = (Button)findViewById(R.id.thursdayButton25);
        d[3][26] = (Button)findViewById(R.id.thursdayButton26);

        d[4][1] = (Button)findViewById(R.id.fridayButton1);
        d[4][2] = (Button)findViewById(R.id.fridayButton2);
        d[4][3] = (Button)findViewById(R.id.fridayButton3);
        d[4][4] = (Button)findViewById(R.id.fridayButton4);
        d[4][5] = (Button)findViewById(R.id.fridayButton5);
        d[4][6] = (Button)findViewById(R.id.fridayButton6);
        d[4][7] = (Button)findViewById(R.id.fridayButton7);
        d[4][8] = (Button)findViewById(R.id.fridayButton8);
        d[4][9] = (Button)findViewById(R.id.fridayButton9);
        d[4][10] = (Button)findViewById(R.id.fridayButton10);
        d[4][11] = (Button)findViewById(R.id.fridayButton11);
        d[4][12] = (Button)findViewById(R.id.fridayButton12);
        d[4][13] = (Button)findViewById(R.id.fridayButton13);
        d[4][14] = (Button)findViewById(R.id.fridayButton14);
        d[4][15] = (Button)findViewById(R.id.fridayButton15);
        d[4][16] = (Button)findViewById(R.id.fridayButton16);
        d[4][17] = (Button)findViewById(R.id.fridayButton17);
        d[4][18] = (Button)findViewById(R.id.fridayButton18);
        d[4][19] = (Button)findViewById(R.id.fridayButton19);
        d[4][20] = (Button)findViewById(R.id.fridayButton20);
        d[4][21] = (Button)findViewById(R.id.fridayButton21);
        d[4][22] = (Button)findViewById(R.id.fridayButton22);
        d[4][23] = (Button)findViewById(R.id.fridayButton23);
        d[4][24] = (Button)findViewById(R.id.fridayButton24);
        d[4][25] = (Button)findViewById(R.id.fridayButton25);
        d[4][26] = (Button)findViewById(R.id.fridayButton26);

        for(int i = 0; i < 5; i++)
            for(int j = 1; j < 27; j++)
                d[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogSettingTime(start, v);
                    }
                });
    }


    //If title = "software", start_time = 1000, end_time = 1130, day_of_week = "Mon"
    public void setButtonColor(String title, String start_time, String end_time, String day_of_week)
    {
        Random random = new Random();

        int dayFlag = -1;

        //Day Check
        if(day_of_week.equals("Mon"))
        {
            dayFlag = 0;
        }else if(day_of_week.equals("Tue"))
        {
            dayFlag = 1;
        }else if(day_of_week.equals("Wed"))
        {
            dayFlag = 2;
        }else if(day_of_week.equals("Thu"))
        {
            dayFlag = 3;
        }else if(day_of_week.equals("Fri"))
        {
            dayFlag = 4;
        }else {
            //Exception "Day is not correct!"
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // If start_time = "1000"
        int s_time = Integer.parseInt(start_time);

        int rs_time = (((s_time / 100) - 8) + 1);

        if(s_time % 100 >= 30)
        {
            rs_time += 1;
        }

        // If end_time = "1130"
        int e_time = Integer.parseInt(end_time);

        int re_time = (((e_time / 100) - 8) + 1);

        if(e_time % 100 >= 30)
        {
            re_time += 1;
        }

        //random color
        colorIndex = random.nextInt(13);

        //print color View
        if(re_time > rs_time) {
            for (int i = rs_time; i < (re_time + 1); i++) {
                Log.i("color", col[colorIndex] + "");
                d[dayFlag][i].setBackgroundColor(col[colorIndex]);
                d[dayFlag][i].setText(title);
            }
        }
        //Exception : time is not correct!
        else try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class getTimeTable extends AsyncTask<String, String, String> {

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
                        String day_of_week = (String) timetable.get("day_of_week");
                        int color = Integer.parseInt((String) timetable.get("color"));
                        setButtonColor(title, start_time, end_time, day_of_week);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }

    private void DialogSettingTime(boolean start, final View v){
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);

        final EditText input = new EditText(this);
        input.setHint("스케쥴을 입력해주세요.");
        alt_bld.setView(input);

        String message = "시작시간";
        if(start)
            message = "끝시간";

        alt_bld.setMessage(message + "으로 설정하시겠습니까?").setCancelable(
                false).setPositiveButton("Save",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Action for 'Yes' Button

                        int hour = 0, day = 0;

                        for(int i = 0; i < 5; i ++)
                            for(int j = 1; j < 27; j++)
                                if(d[i][j] == (Button) v ) {
                                    day = i;
                                    hour = j;
                                    break;
                                }

                        start_time = hour + "";
                        day_of_week = day + "";

                        Log.e("TIMETABLE", start_time + " " + day_of_week);
                    }
                }).setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Action for 'NO' Button
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alt_bld.create();
        // Title for AlertDialog
        alert.setTitle("Add Schedule!");
        // Icon for AlertDialog
        alert.setIcon(R.drawable.icon_logo2_small);
        alert.show();
    }
}
