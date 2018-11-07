package com.example.vito.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class HelloActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        Log.d("States", "onCreate");

        /*text = findViewById(R.id.textEvent);

        text.setOnClickListener(this);

        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HelloActivity.this, "Has hecho click con listener", Toast.LENGTH_LONG).show();
            }
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("States", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("States", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("States", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("States", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("States", "onDestroy");
    }

    public void initSecundaryActivity(View view)
    {
        //Toast.makeText(this, "Has hecho click en el texto", Toast.LENGTH_LONG).show();

        Intent initSecundary = new Intent(this, FragmentsActivity.class);

        /*initSecundary.putExtra("numero", 5);
        initSecundary.putExtra("nombre", "Paquito");*/

        startActivity(initSecundary);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(HelloActivity.this, "Has hecho click con listener", Toast.LENGTH_LONG).show();
    }

    public void createAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "A levantarse")
                .putExtra(AlarmClock.EXTRA_HOUR, 9)
                .putExtra(AlarmClock.EXTRA_MINUTES, 30);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void callPhone(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:667241958"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void breakdownChecked(View view) {
        boolean isElementChecked = ((CheckBox)view).isChecked();
        String typeElement = "";

        switch (view.getId())
        {
            case R.id.chapa:
                typeElement = "Chapa y pintura";
                break;
            case R.id.cristal:
                typeElement = "Cristal roto";
                break;
            case R.id.mecanica:
                typeElement = "Avería mecánica";
                break;
        }

        Toast.makeText(this, typeElement + "(" + isElementChecked + ")" , Toast.LENGTH_SHORT).show();
    }
}
