package com.crew.ui.crew;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.crew.R;

public class NoticeDetailActivity extends ActionBarActivity {

    private CardView mSaveButton, mCancelButton;
    private EditText mCrewNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        String name = (String) getIntent().getExtras().get("notice");

        TextView noticeDetailTitle = (TextView) findViewById(R.id.crewNameTextView);
        noticeDetailTitle.setText(name);

        mCrewNameEditText = (EditText) findViewById(R.id.crewNameEditText);
        mCrewNameEditText.setText(name);

        mSaveButton = (CardView) findViewById(R.id.saveAddNoticeButton);
        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Save", "수정내용 저장.");
                // 수정 후 메시지 출력
                Toast.makeText(getBaseContext(), "수정내용 저장", Toast.LENGTH_LONG).show();
                // 수정한 값을 전달하는 쿼리문 전달

                // 종료
                finish();
            }
        });

        mCancelButton = (CardView) findViewById(R.id.closeAddNoticeButton);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아무런 행동없이 Activity 종료.
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notice_detail, menu);
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
}
