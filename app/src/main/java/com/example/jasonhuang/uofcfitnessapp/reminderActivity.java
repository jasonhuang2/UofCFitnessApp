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
    String date, month , year;
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

        Intent myintent = getIntent();

        date = myintent.getStringExtra("Date");
        month = myintent.getStringExtra("Month");
        year = myintent.getStringExtra("Year");


        int date_int = Integer.parseInt(date);
        int month_int = Integer.parseInt(month);
        int year_int = Integer.parseInt(year);

        //IMPORTANT WHATEVER HOUR WE PICKED
        //Set calendar instance with the hour and minute we chose on the time_picker
        final Calendar calendar = Calendar.getInstance();
     //   calendar.set(Calendar.DAY_OF_MONTH, date_int);
      //  calendar.set(Calendar.MONTH, month_int);
       // calendar.set(Calendar.YEAR, year_int);
        calendar.set(Calendar.HOUR_OF_DAY, alarm_picker.getCurrentHour());
        calendar.set(Calendar.MINUTE, alarm_picker.getCurrentMinute());

        /*
        final Calendar dateCalendar = Calendar.getInstance();
        dateCalendar.set(Calendar.DAY_OF_MONTH, date_int);
        dateCalendar.set(Calendar.MONTH, month_int);
        dateCalendar.set(Calendar.YEAR, year_int);
*/





        //Get string value of inputted hour and minute
        int hour = alarm_picker.getCurrentHour();
        int minute = alarm_picker.getCurrentMinute();

        //Now want to convert int hour and int minute into strings
        String string_hour = String.valueOf(hour);
        String string_minute = String.valueOf(minute);

        //Convert 24-hour to 12 hour
        if(hour > 12){
            hour = hour - 12;
        }
        if(minute < 10){
            string_minute = "0" + String.valueOf(minute);

        }
        if(hour > 12){
            //Now display it onto the textbox
            textBox.setText("Alarm set to: " + string_hour + ":" + string_minute + "pm" + " on " + month + "/" + date + "/" + year);
        }else{
            //Now display it onto the textbox
            textBox.setText("Alarm set to: " + string_hour + ":" + string_minute + "am" + " on " + month + "/" + date + "/" + year);
        }

        //Creates pending intent that delays the intent until the specified time is reached
        pending_intent = PendingIntent.getBroadcast(reminderActivity.this, 0, my_intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //Alarm manager
        alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pending_intent);

   //     alarm_manager.set(AlarmManager.RTC_WAKEUP, dateCalendar.getTimeInMillis() + calendar.getTimeInMillis(),pending_intent);



    }

    public void offListener(View v){
        textBox.setText("Alarm is shut off");

        alarm_manager.cancel(pending_intent);
    }
    public void selectDate(View v){
        Intent intent = new Intent(this, dateActivity.class);
        startActivity(intent);
    }
}
