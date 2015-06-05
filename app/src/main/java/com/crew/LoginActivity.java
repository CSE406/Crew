package com.crew;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.crew.ui.MainActivity;
import com.crew.ui.group.MainFragment;
import com.crew.ui.material.Button;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class LoginActivity extends FragmentActivity {
    private MainFragment mainFragment;
    private LoginButton loginButton;
    private Button guestButton;
    private CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.facebook_login_button);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {

                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException e) {

                    }
                }
        );

        guestButton = (Button) findViewById(R.id.guest_login_button);
        guestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
