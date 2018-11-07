package com.example.vito.openwebinarscurse.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.vito.openwebinarscurse.R;

public class LoginActivity extends AppCompatActivity {
    private SharedPreferences myPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        myPreferences = getSharedPreferences(getString(R.string.preferences_file), Context.MODE_PRIVATE);
        boolean isLogged = myPreferences.getBoolean(getString(R.string.preferences_isUserLogin), false);

        if(isLogged) {
            Intent starterMainActivity = new Intent(this, MainActivity.class);
            startActivity(starterMainActivity);
        }
        else {
            RequestOptions cropOptions = new RequestOptions().fitCenter();

            Glide.with(this)
                    .load("http://miguelcamposrivera.com/logo_mecaround.png")
                    .apply(cropOptions)
                    .into((ImageView) findViewById(R.id.logoApp));
        }
    }

    public void doLogin(View view) {
        String emailLogin = ((EditText)findViewById(R.id.emailInput)).getText().toString();
        String passwordLogin = ((EditText)findViewById(R.id.passwordInput)).getText().toString();

        if (emailLogin.equals("alsamon1@hotmail.com") && passwordLogin.equals("12345")) {
            if(((CheckBox)findViewById(R.id.isRemember)).isChecked()) {
                SharedPreferences.Editor editorPreferenes = myPreferences.edit();

                editorPreferenes.putString(getString(R.string.preferences_userLogin), emailLogin);
                editorPreferenes.putBoolean(getString(R.string.preferences_isUserLogin), true);
                editorPreferenes.apply();
            }
            Intent starterMainActivity = new Intent(this, MainActivity.class);
            startActivity(starterMainActivity);
        }
        else
            Snackbar.make(view, R.string.incorrect_credentials, Snackbar.LENGTH_LONG).show();
    }
}
