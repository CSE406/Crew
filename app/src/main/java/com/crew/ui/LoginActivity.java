package com.crew.ui;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.crew.R;
import com.crew.ui.crew.UserDTO;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;


public class LoginActivity extends FragmentActivity {
    static UserDTO userDTO = new UserDTO();
    private LoginButton loginButton;
    private Button guestButton;
    private CallbackManager callbackManager;
    private boolean success_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        LoginManager.getInstance().logOut();

        setContentView(R.layout.activity_login);
        callbackManager = CallbackManager.Factory.create();
        loginButton = (LoginButton) findViewById(R.id.facebook_login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile, email"));
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.i("facebook", "login success");

                        // Request user profile and email
                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(
                                            JSONObject object,
                                            GraphResponse response) {

                                        // Get user profile from JSON
                                        Log.i("facebook", "get user profile");
                                        success_flag = true;
                                        try{
                                            userDTO.setFacebookId(object.getString("id"));
                                            userDTO.setName(object.getString("name"));
                                            userDTO.setEmail(object.getString("email"));
                                        }
                                        catch(JSONException e)
                                        {
                                            Log.e("facebook",e.getMessage());
                                            Toast.makeText(getApplicationContext(),
                                                    "Failed to get profile from Facebook!", Toast.LENGTH_SHORT).show();
                                            success_flag = false;
                                        }

                                        // Success getting user profile from JSON
                                        if(success_flag)
                                        {
                                            Log.i("facebook","name: "+userDTO.getName());
                                            Log.i("facebook","facebookId: "+userDTO.getfacebookId());
                                            Log.i("facebook","email: "+userDTO.getEmail());

                                            // If user already has been signed in
                                            if(isSignedIn(userDTO.getfacebookId()))
                                            {
                                                // update user data
                                            }
                                            else
                                            {
                                                // insert user data
                                            }

                                            Toast.makeText(getApplicationContext(),
                                                    "Welcome " + userDTO.getName() + "!", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }


                                    }
                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "id, name, email");
                        request.setParameters(parameters);
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {
                        Toast.makeText(getApplicationContext(), "Login canceled!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException e) {
                        Toast.makeText(getApplicationContext(), "Login error!", Toast.LENGTH_SHORT).show();
                        Log.e("facebook", e.getMessage());
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private boolean isSignedIn(String facebookId)
    {
        return false;
    }
}
