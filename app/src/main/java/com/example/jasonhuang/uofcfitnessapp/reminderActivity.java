package com.example.jasonhuang.uofcfitnessapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class reminderActivity extends AppCompatActivity {

    Context context;
    AlarmManager alarm_manager;
    TimePicker alarm_picker;
    PendingIntent pending_intent;

    TextView textBox;
    Intent my_intent;
    Button asdf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder_layout);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.context = this;

        alarm_manager = (AlarmManager)getSystemService(ALARM_SERVICE);
        alarm_picker = (TimePicker)findViewById(R.id.timePicker);

        textBox = (TextView)findViewById(R.id.ahhh);

        my_intent = new Intent(this.context, BroadcastManager.class);


    }

    public void alarmListener(View v){
        //IMPORTANT WHATEVER HOUR WE PICKED
        //Set calendar instance with the hour and minute we chose on the time_picker
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, alarm_picker.getCurrentHour());
        calendar.set(Calendar.MINUTE, alarm_picker.getCurrentMinute());

        //Get string value of inputted hour and minute
        int hour = alarm_picker.getCurrentHour();
        int minute = alarm_picker.getCurrentMinute();

        //Convert 24-hour to 12 hour
        if(hour > 12){
            hour = hour - 12;

        }

        //Now want to convert int hour and int minute into strings
        String string_hour = String.valueOf(hour);
        String string_minute = String.valueOf(minute);

        if(minute < 10){
            string_minute = "0" + String.valueOf(minute);

        }
        //Now display it onto the textbox
        textBox.setText("Alarm set to: " + string_hour + ":" + string_minute);


        //Creates pending intent that delays the intent until the specified time is reached
        pending_intent = PendingIntent.getBroadcast(reminderActivity.this, 0, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //Alarm manager
        alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pending_intent);

    }

    public void offListener(View v){
        textBox.setText("Alarm is shut off");

        alarm_manager.cancel(pending_intent);
    }
}
