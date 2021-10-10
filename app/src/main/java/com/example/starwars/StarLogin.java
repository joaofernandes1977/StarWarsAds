package com.example.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class StarLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_login);
        getSupportActionBar().hide();
    }
}