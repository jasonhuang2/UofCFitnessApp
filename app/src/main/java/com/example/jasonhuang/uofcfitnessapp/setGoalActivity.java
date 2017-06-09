package com.example.jasonhuang.uofcfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
            calendarButtonDate.setText(month + " / " + date + " / " + year);
        }

        Button muscleExerciseText = (Button)findViewById((R.id.muscleGroupButton));
        Intent myintent2 = getIntent();

        String muscleGroupName = myintent2.getStringExtra("muscleGroupName");
        String exerciseName = myintent2.getStringExtra("exerciseName");

        if(muscleGroupName == null){
            muscleExerciseText.setText("(Muscle Group and Exercise)");
        }else{
            muscleExerciseText.setText(muscleGroupName + " / " + exerciseName);
        }

    }




    //Button method to get to the calendar activity to set up a date
    public void calendarButton(View v){
        Intent intent2 = new Intent(this, CalendarActivity.class);
        startActivity(intent2);
    }
    //Button method to get to the muscle selection activity to set up a date
    public void muscleGroupButton(View v){
        Intent intent = new Intent(this, muscleGroupActivity.class);
        startActivity(intent);
    }
}

