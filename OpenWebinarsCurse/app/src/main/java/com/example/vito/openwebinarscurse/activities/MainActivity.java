package com.example.vito.openwebinarscurse.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.vito.openwebinarscurse.BreakdownInfoActivity;
import com.example.vito.openwebinarscurse.fragments.WorkshopFragment;
import com.example.vito.openwebinarscurse.entities.Breakdown;
import com.example.vito.openwebinarscurse.fragments.BreakdownFragment;
import com.example.vito.openwebinarscurse.interfaces.CloseSessionListener;
import com.example.vito.openwebinarscurse.R;
import com.example.vito.openwebinarscurse.dialogs.CloseSessionDialog;
import com.example.vito.openwebinarscurse.dialogs.NewItemDialog;
import com.example.vito.openwebinarscurse.interfaces.OnBreakdownInteractionListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        CloseSessionListener, OnBreakdownInteractionListener {

    private DialogFragment newItemDialog;
    private CloseSessionDialog closeSessionDialog;
    private SharedPreferences myPreferences;

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
                newItemDialog = new NewItemDialog();
                newItemDialog.show(getSupportFragmentManager(), "New breakdown");
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_breakdown);
        changeContentFragment(new BreakdownFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            finish();
            moveTaskToBack(true);
            System.exit(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_breakdown) {
            changeContentFragment(new BreakdownFragment());
        } else if (id == R.id.nav_workshop) {
            changeContentFragment(new WorkshopFragment());
        } else if (id == R.id.nav_exit) {
            closeSessionDialog = new CloseSessionDialog();
            closeSessionDialog.show(getSupportFragmentManager(), "closeSessionDialog");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void closeSession() {
        myPreferences = getSharedPreferences(getString(R.string.preferences_file), Context.MODE_PRIVATE);

        SharedPreferences.Editor editorPreferenes = myPreferences.edit();

        editorPreferenes.putString(getString(R.string.preferences_userLogin), "");
        editorPreferenes.putBoolean(getString(R.string.preferences_isUserLogin), false);
        editorPreferenes.apply();

        Intent starterLoginActivity = new Intent(this, LoginActivity.class);
        startActivity(starterLoginActivity);
    }

    @Override
    public void onBreakdownClicked(Breakdown breakdown) {
        Intent starterMainActivity = new Intent(this, BreakdownInfoActivity.class);
        startActivity(starterMainActivity);
    }

    private void changeContentFragment(Fragment newFragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentMainActivity, newFragment)
                .commit();
    }
}
