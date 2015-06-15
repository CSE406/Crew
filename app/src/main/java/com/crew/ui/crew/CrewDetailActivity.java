package com.crew.ui.crew;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.crew.R;
import com.crew.ui.material.FloatingActionButton;

import org.w3c.dom.Text;

public class CrewDetailActivity extends ActionBarActivity {

    private RelativeLayout mCrewDetailLayout, mAddNoticeLayout, mMemberLayout, mInformationLayout,
            /*mOptionLayout,*/ mLeadersLayout, mAuthorLayout;
    private ListView mTodayListView, mNoticeListView, mMemberListView;
    private MemberListAdapter mMemberListAdapter;
    private TodayListAdapter mTodayListAdapter;
    private NoticeListAdapter mNoticeListAdapter;
    private CardView mAddNoticeButton, mCloseAddNoticeButton, mCloseMemberButon, mCloseInformaitonButton,
            /*mCloseOptionButton,*/ mCloseLeaderButton, mInviteButton, mChangeButton, mAuthorizeButton, mDeleteButton,
            mCloseAuthorizeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crew_detail);

        String name = (String) getIntent().getExtras().get("crewName");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.crewDetailMenuButton);
        fab.setDrawableIcon(getResources().getDrawable(R.drawable.button_icon));
        fab.setBackgroundColor(getResources().getColor(R.color.purple_500));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogMenu();
            }
        });

        mCrewDetailLayout = (RelativeLayout) findViewById(R.id.crewDetailLayout);
        mAddNoticeLayout = (RelativeLayout) findViewById(R.id.addNoticeLayout);
        mMemberLayout = (RelativeLayout) findViewById(R.id.memberLayout);
        mInformationLayout = (RelativeLayout) findViewById(R.id.informationLayout);
//        mOptionLayout = (RelativeLayout) findViewById(R.id.optionLayout);
        mLeadersLayout = (RelativeLayout) findViewById(R.id.leadersLayout);
        mAuthorLayout = (RelativeLayout) findViewById(R.id.authorLayout);

        TextView mCrewDetailLayoutTitle = (TextView) findViewById(R.id.crewNameTextView);
        mCrewDetailLayoutTitle.setText(name);

        mTodayListAdapter = new TodayListAdapter(this);
        mTodayListView = (ListView) findViewById(R.id.crewTodayListView);
        mTodayListView.setAdapter(mTodayListAdapter);

        mTodayListAdapter.addItem("10:30", "Y05-301", "Our Regular Meeting..");
        mTodayListAdapter.addItem("12:00", "Y05-301", "Next Meeting is on..");
        mTodayListAdapter.addItem("3:00", "Andante", "Special Party");

        mAddNoticeButton = (CardView) findViewById(R.id.addNoticeButton);
        mAddNoticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCrewDetailLayout.setVisibility(View.GONE);
                mAddNoticeLayout.setVisibility(View.VISIBLE);
            }
        });

        mCloseAddNoticeButton = (CardView) findViewById(R.id.closeAddNoticeButton);
        mCloseAddNoticeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAddNoticeLayout.setVisibility(View.GONE);
                mCrewDetailLayout.setVisibility(View.VISIBLE);
            }
        });

        mNoticeListAdapter = new NoticeListAdapter(this);
        mNoticeListView = (ListView) findViewById(R.id.crewNoticeListView);
        mNoticeListView.setAdapter(mNoticeListAdapter);

        mNoticeListAdapter.addItem("1st", "Plz..make some Problem");
        mNoticeListAdapter.addItem("2nd", "I Hate This Project!");
        mNoticeListAdapter.addItem("3rd", "What the Fuck!");
        mNoticeListAdapter.addItem("1st", "Plz..make some Problem");
        mNoticeListAdapter.addItem("2nd", "I Hate This Project!");
        mNoticeListAdapter.addItem("3rd", "What the Fuck!");

        // Members

        mMemberListAdapter = new MemberListAdapter(this);
        mMemberListView = (ListView) findViewById(R.id.memberListView);
        mMemberListView.setAdapter(mMemberListAdapter);

        mMemberListAdapter.addItem("Dongjun", "Staff", "ehdwns2045@gmail.com");
        mMemberListAdapter.addItem("HaHa", "Leader", "crew@crew.com");
        mMemberListAdapter.addItem("Google", "Member", "hoho@naver.com");
        mMemberListAdapter.addItem("Dongjun", "Staff", "ehdwns2045@gmail.com");
        mMemberListAdapter.addItem("HaHa", "Leader", "crew@crew.com");
        mMemberListAdapter.addItem("Google", "Member", "hoho@naver.com");
        mMemberListAdapter.addItem("Dongjun", "Staff", "ehdwns2045@gmail.com");
        mMemberListAdapter.addItem("HaHa", "Leader", "crew@crew.com");
        mMemberListAdapter.addItem("Google", "Member", "hoho@naver.com");

        mCloseMemberButon = (CardView) findViewById(R.id.closeMemberButton);
        mCloseMemberButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMemberLayout.setVisibility(View.GONE);
                mCrewDetailLayout.setVisibility(View.VISIBLE);
            }
        });

        // Information

        mCloseInformaitonButton = (CardView) findViewById(R.id.closeInformationButton);
        mCloseInformaitonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mInformationLayout.setVisibility(View.GONE);
                mCrewDetailLayout.setVisibility(View.VISIBLE);
            }
        });

//        // Option
//
//        mCloseOptionButton = (CardView) findViewById(R.id.closeOptionButton);
//        mCloseOptionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mOptionLayout.setVisibility(View.GONE);
//                mCrewDetailLayout.setVisibility(View.VISIBLE);
//            }
//        });

        // Leaders

        mInviteButton = (CardView) findViewById(R.id.inviteButton);
        mInviteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInvite();
            }
        });

        mChangeButton = (CardView) findViewById(R.id.changeButton);
        mChangeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogChange();
            }
        });

        mDeleteButton = (CardView) findViewById(R.id.deleteButton);
        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogDelete();
            }
        });

        mAuthorizeButton = (CardView) findViewById(R.id.authorizeButton);
        mAuthorizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLeadersLayout.setVisibility(View.GONE);
                mAuthorLayout.setVisibility(View.VISIBLE);
            }
        });

        mCloseAuthorizeButton = (CardView) findViewById(R.id.closeAuthorizeButton);
        mCloseAuthorizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuthorLayout.setVisibility(View.GONE);
                mLeadersLayout.setVisibility(View.VISIBLE);
            }
        });

        mCloseLeaderButton = (CardView) findViewById(R.id.closeLeaderButton);
        mCloseLeaderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLeadersLayout.setVisibility(View.GONE);
                mCrewDetailLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_crew_detail, menu);
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

    private void DialogMenu(){
        final CharSequence[] mainMenu = {"Members", "Information", /*"Options",*/ "Leader's"};
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(CrewDetailActivity.this);
        alt_bld.setIcon(R.drawable.icon_logo2_small);
        alt_bld.setTitle("Select Menu!");
        alt_bld.setItems(mainMenu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (mainMenu[item] == mainMenu[0]) {
                    mCrewDetailLayout.setVisibility(View.GONE);
                    mMemberLayout.setVisibility(View.VISIBLE);
                } else if (mainMenu[item] == mainMenu[1]) {
                    mCrewDetailLayout.setVisibility(View.GONE);
                    mInformationLayout.setVisibility(View.VISIBLE);
//                } else if (mainMenu[item] == mainMenu[2]) {
//                    mCrewDetailLayout.setVisibility(View.GONE);
//                    mOptionLayout.setVisibility(View.VISIBLE);
                } else if (mainMenu[item] == mainMenu[2]) {
                    mCrewDetailLayout.setVisibility(View.GONE);
                    mLeadersLayout.setVisibility(View.VISIBLE);
                }
            }
        });
        AlertDialog alert = alt_bld.create();
        alert.show();
    }

    private void DialogInvite(){
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);

        final EditText input = new EditText(this);
        alt_bld.setView(input);

        alt_bld.setMessage("Invite Your Friends!").setCancelable(
                false).setPositiveButton("Send",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Action for 'Yes' Button
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
        alert.setTitle("INVITE");
        // Icon for AlertDialog
        alert.setIcon(R.drawable.icon_logo2_small);
        alert.show();
    }

    private void DialogChange(){
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);

        final EditText input = new EditText(this);
        alt_bld.setView(input);

        alt_bld.setMessage("Change Crew's Name!").setCancelable(
                false).setPositiveButton("Save",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Action for 'Yes' Button
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
        alert.setTitle("Change Name");
        // Icon for AlertDialog
        alert.setIcon(R.drawable.icon_logo2_small);
        alert.show();
    }

    private void DialogDelete(){
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setMessage("Are you sure?").setCancelable(
                false).setPositiveButton("Delete",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Action for 'Yes' Button
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
        alert.setTitle("DELETE Crew");
        // Icon for AlertDialog
        alert.setIcon(R.drawable.icon_logo2_small);
        alert.show();
    }
}
