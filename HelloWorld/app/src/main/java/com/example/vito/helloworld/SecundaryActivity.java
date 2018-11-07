package com.example.vito.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecundaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundary);

        Bundle extras = getIntent().getExtras();

        int num = extras.getInt("numero");
        String nombre = extras.getString("nombre");

        Toast.makeText(this,
                "nombre: " + nombre + ", numero: " + num,
                Toast.LENGTH_SHORT).show();
    }
}
