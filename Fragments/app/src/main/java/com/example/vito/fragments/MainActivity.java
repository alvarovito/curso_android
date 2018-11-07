package com.example.vito.fragments;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private boolean isFirstFragmentSelected = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragmentToLoad;

                if(isFirstFragmentSelected)
                    fragmentToLoad = new SecondFragment();
                else
                    fragmentToLoad = new FirstFragment();

                isFirstFragmentSelected = !isFirstFragmentSelected;

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_container, fragmentToLoad)
                        .commit();
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_container, new FirstFragment())
                .commit();
    }
}
