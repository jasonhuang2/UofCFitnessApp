package com.example.jasonhuang.uofcfitnessapp;

import android.content.Intent;
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

        //This is for the back button.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Once the confirm button is pressed.
    public void calendarConfirmButton(View v){
         DatePicker theDatePicker = (DatePicker)findViewById(R.id.datePicker) ;

        //All i am doing here is extracting the day, month and year from the date picker; the user chosen date.
        int day = theDatePicker.getDayOfMonth();
        int month = theDatePicker.getMonth() + 1;
        int year = theDatePicker.getYear();

        //Send all this data back to the class where it was called.
        Intent intent2 = new Intent(this, setGoalActivity.class);
        intent2.putExtra("Date",Integer.toString(day));
        intent2.putExtra("Month",Integer.toString(month));
        intent2.putExtra("Year",Integer.toString(year));
        startActivity(intent2);
    }
}
