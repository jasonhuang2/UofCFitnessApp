package com.example.jasonhuang.uofcfitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

  //  DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
   // int day = datePicker.getDayOfMonth();
    //int month = datePicker.getMonth() + 1;
    //int year = datePicker.getYear();




    public void calendarConfirmButton(View v){
       DatePicker thedatePicker = (DatePicker)findViewById(R.id.datePicker) ;
        Button date = (Button)findViewById(R.id.dateSetButton);
        int day = thedatePicker.getDayOfMonth();
        date.setText(Integer.toString(day));
    }

  //  public int getDay(){
    //    DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
      //  int day = datePicker.getDayOfMonth();

        //return day;
    //}

}