package com.example.asus.funfact.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.asus.funfact.R;

public class FunfactlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funfactlist);

        // get intent from previous
        Intent intent = getIntent();
        boolean language = intent.getBooleanExtra("language" , "false" , false);
        if (language == FunfactActivity.ENGLISH_LANG)
        {
            Toast.makeText(getApplicationContext(), "ENGLISH" , Toast.LENGTH_LONG).show();
        } else
        {
            Toast.makeText(getApplicationContext(), "INDONESIA" , Toast.LENGTH_LONG).show();
        }
    }
}
