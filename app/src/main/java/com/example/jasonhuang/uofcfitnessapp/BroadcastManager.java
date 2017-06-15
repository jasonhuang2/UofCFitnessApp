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



    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        String state = intent.getExtras().getString("extra");
        Toast.makeText(context, "It is time to workout",Toast.LENGTH_SHORT).show();

        Intent serviceIntent = new Intent(context,TriggerManager.class);
        serviceIntent.putExtra("extra", state);

        context.startService(serviceIntent);




    }


}