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


        Button calendarButtonDate = (Button)findViewById(R.id.dateSetButton);
        Intent myintent = getIntent();

        String date = myintent.getStringExtra("Date");
        String month = myintent.getStringExtra("Month");
        String year = myintent.getStringExtra("Year");


        if(date == null){                                                       //I need it to print (Date) instead of Null/Null/Null
            calendarButtonDate.setText("(Date)");
        }else{
            calendarButtonDate.setText(month + "/" + date + "/" + year);
        }
    }

    public void calendarButton(View v){
        Intent intent2 = new Intent(this, CalendarActivity.class);
        startActivity(intent2);
    }

}

