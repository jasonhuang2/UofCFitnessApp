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

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void returnDateButton(View v){

        DatePicker theDatePicker = (DatePicker)findViewById(R.id.datePicker2) ;

        int day = theDatePicker.getDayOfMonth();
        int month = theDatePicker.getMonth() + 1;
        int year = theDatePicker.getYear();

        Intent intent2 = new Intent(this, reminderActivity.class);
        intent2.putExtra("Date",Integer.toString(day));
        intent2.putExtra("Month",Integer.toString(month));
        intent2.putExtra("Year",Integer.toString(year));
        startActivity(intent2);
    }
}
