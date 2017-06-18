package com.example.jasonhuang.uofcfitnessapp;


import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;



/**
 * Created by jasonhuang on 2017-06-13.
 */



public class BroadcastManager extends BroadcastReceiver{
    @Override
    //Think of this as a "what happens" when the timer hits 0.
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String state = intent.getExtras().getString("extra");
        //Make a toast to let the user know.
        Toast.makeText(context, "It is time to workout",Toast.LENGTH_SHORT).show();

        //I want to start the Trigger manager which is the notification class.
        Intent serviceIntent = new Intent(context,TriggerManager.class);
        serviceIntent.putExtra("extra", state);

        context.startService(serviceIntent);
    }
}