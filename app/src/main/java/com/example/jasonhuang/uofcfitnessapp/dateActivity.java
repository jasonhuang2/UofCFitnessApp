package com.example.jasonhuang.uofcfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

public class dateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_layout);

        //This is for the back button.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    //Once the confirm button is pressed.
    public void returnDateButton(View v){

        DatePicker theDatePicker = (DatePicker)findViewById(R.id.datePicker2) ;

        //All I am doing here is extracting the day, month and year from the date picker; the user chosen date.
        int day = theDatePicker.getDayOfMonth();
        int month = theDatePicker.getMonth();
        int year = theDatePicker.getYear();

        //Send all this data back to the class where it was called.
        Intent intent2 = new Intent(this, reminderActivity.class);
        intent2.putExtra("Date",String.valueOf(day));
        intent2.putExtra("Month",String.valueOf(month));
        intent2.putExtra("Year",String.valueOf(year));
        startActivity(intent2);
    }
}
