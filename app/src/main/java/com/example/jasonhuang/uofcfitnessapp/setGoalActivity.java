package com.example.jasonhuang.uofcfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class setGoalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_goal_layout);

        //For the back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView bob = (TextView)findViewById(R.id.textView);
        Intent myintent = getIntent();
        String date = myintent.getStringExtra("Date");
        bob.setText(date);

    }
    public void calendarButton(View v){
        Intent intent2 = new Intent(this, CalendarActivity.class);
        //intent2.putExtra("Date", "10");
        startActivity(intent2);



    }


    }

