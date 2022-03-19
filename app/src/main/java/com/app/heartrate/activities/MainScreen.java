package com.app.heartrate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.heartrate.R;

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void getPrediction(View view) {
        startActivity(new Intent(this, FormPrediction.class));
    }

    public void history(View view) {
        startActivity(new Intent(this, HistoryActivity.class));
    }
}