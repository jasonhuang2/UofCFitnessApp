package com.example.jasonhuang.uofcfitnessapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class setGoalActivity extends AppCompatActivity {

    public static Date gdate = null;
    public static String exercise = null;
    public static String musclegroup = null;
    public static int reps = 0;
    private String ip = "sql5023.smarterasp.net";    //enter ip address here
    private String db = "DB_A263B4_test";    //emter database name here
    private String un = "DB_A263B4_test_admin";    //enter username here
    private String pass = "nightonfire123";  //enter password here
    private Connection conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_goal_layout);

        //Need these two lines in order to set the back button. Not only that, remember to change the AndroidManifest.xml file too to sync the activity with the button.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Button calendarButtonDate = (Button)findViewById(R.id.dateSetButton);

        //User selected date, month and year will be returned to this activity so we can print it onto the button's text.
        Intent myintent = getIntent();

        String date = myintent.getStringExtra("Date");
        String month = myintent.getStringExtra("Month");
        String year = myintent.getStringExtra("Year");

        //If it is null, then there is nothing in it.
        //I need it to print (Date) instead of Null/Null/Null
        if(date == null && gdate == null){
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
        //Now we want the muscle group and exercise returned to this activity.
        Intent myintent2 = getIntent();

        String muscleGroupName = myintent2.getStringExtra("muscleGroupName");
        String exerciseName = myintent2.getStringExtra("exerciseName");

        //If it is null then that means there is nothing in it.
        if(muscleGroupName == null && musclegroup == null){
            muscleExerciseText.setText("(Muscle Group and Exercise)");
        }else if (muscleGroupName != null){
            muscleExerciseText.setText(muscleGroupName + " / " + exerciseName);
            musclegroup = muscleGroupName;
            exercise = exerciseName;
        }
        else {muscleExerciseText.setText(musclegroup + " / " + exercise);
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
    public void setButtonReturn(View v){
        conn = getConnection();
        //Conversion of reps to string.
        EditText repCounter = (EditText)findViewById(R.id.numberofRepsInput);
        String rep = repCounter.getText().toString();
        reps = Integer.parseInt(rep);
        //If all of these are NOT NULL than that means there is something in it. If so, store them all onto the database.
        if ((gdate != null) && (exercise != null) && (musclegroup != null) && (reps != 0) && (conn != null)){
            try{
            String query = "INSERT INTO " + db + ".dbo.goal(goalDate, muscleGroup, exercise, reps) VALUES ( '" + gdate + "', '"+ musclegroup +"' , '"+ exercise +"', " + reps + ")";
            Statement stmt = conn.createStatement();
                stmt.execute(query);}

            catch (SQLException e) {

                e.printStackTrace();
            }
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    //For testing purposes.
    public Connection getConnection(){
        return connectionclass(un, pass, db, ip);

    }
    //This is the connection class, what it does is it takes the username, ip address, password and logs us into our database.
    public Connection connectionclass (String user, String pass, String db, String server){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURL = null;

        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc:jtds:sqlserver://" + server + ";" + "databseName=" + db + ";user=" + user + ";password=" + pass + ";";
            connection = DriverManager.getConnection(connectionURL);

        }catch(Exception e){
            Log.e("Error: ", e.getMessage());
        }

        return connection;
    }
}


