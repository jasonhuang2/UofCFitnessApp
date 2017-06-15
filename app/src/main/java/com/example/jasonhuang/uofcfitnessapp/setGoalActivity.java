package com.example.jasonhuang.uofcfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class setGoalActivity extends AppCompatActivity {

    public static Date gdate = null;
    public static String exercise = null;
    public static String musclegroup = null;
    public static int reps = 0;



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







        if(date == null && gdate == null){                                                       //I need it to print (Date) instead of Null/Null/Null
            calendarButtonDate.setText("(Date)");}
        else if (date != null){
            if (date.length() == 1 ){
                date = "0"+date;
            }
            if(month.length() == 1){
                month = "0"+month;
            }
            String sdate = month+ "/" + date+ "/" + year;
            try {
                long epoch = new java.text.SimpleDateFormat("MM/dd/yyyy").parse(sdate).getTime();
                gdate = new Date(epoch);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            calendarButtonDate.setText(month + " / " + date + " / " + year);
        }
        else if(gdate != null){
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            String strDate = dateFormat.format(gdate);
            calendarButtonDate.setText(strDate);
        }

        Button muscleExerciseText = (Button)findViewById((R.id.muscleGroupButton));
        Intent myintent2 = getIntent();

        String muscleGroupName = myintent2.getStringExtra("muscleGroupName");
        //musclegroup = muscleGroupName;
        String exerciseName = myintent2.getStringExtra("exerciseName");
        //exercise = exerciseName;

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

