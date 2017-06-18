package com.example.jasonhuang.uofcfitnessapp;


import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;

/**
 * Created by jasonhuang on 2017-06-14.
 */

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class TriggerManager extends Service {
    private static final int uniqueID = 45612;
    NotificationCompat.Builder notification;

    @Nullable
    //Not sure what this function does but the notification class requires this function in order to work.
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //Once this class is called, then it will come to here; it is similar to the onCreate function for actvitites.
    public int onStartCommand(Intent intent, int flags, int startID){
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        //Give the notification an icon, title and text.
        notification.setSmallIcon(R.mipmap.ic_launcher);
       // notification.setTicker("This is a ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Workout Notification");
        notification.setContentText("Time for some gains");


        //Once the notification is pressed, the main menu will pop up.
        Intent intent2 = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent2, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        //Start up the notification.
        android.app.NotificationManager mNm = (android.app.NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        //Link them.
        mNm.notify(0, notification.build());
        return START_NOT_STICKY;

    }

}
