package com.example.jasonhuang.uofcfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class addExerciseActivity extends AppCompatActivity {

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
        setContentView(R.layout.add_exercise_layout);

        //Need these two lines in order to set the back button. Not only that, remember to change the AndroidManifest.xml file too to sync the activity with the button.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Now I want the muscle group and muscle exercise returned from the addExerciseMuscleGroupActivity and update the button's text
        Button muscleExerciseText = (Button)findViewById((R.id.addExerciseMuscleGroup));
        Intent myintent2 = getIntent();

        //User selected muscle group name and exercise is stored into these two strings.
        String muscleGroupName = myintent2.getStringExtra("muscleGroupName2");
        String exerciseName = myintent2.getStringExtra("exerciseName2");

        //Once this activity is started, muscleGroupName and musclegroup will be null, so print out text.
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
    //This function is it will create a new intent of the add exercise muscle group and start it.
    public void addExerciseButton(View v){
        Intent intent = new Intent(this, addExerciseMuscleGroupActivity.class);
        startActivity(intent);
    }

    public void setButtonReturn2(View v){
        //I want the system time printed out onto a string into the "MM/dd/yyyy" format.
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        String formattedDate = df.format(c.getTime());

        //Create a new connection class.
        conn = connectionclass(un, pass, db, ip);
        EditText repCounter = (EditText)findViewById(R.id.addExerciseRep);
        String rep = repCounter.getText().toString();
        reps = Integer.parseInt(rep);
        //If all of these are NOT null, then that means they all hold something. Store all of these into the database.
        if ((exercise != null) && (musclegroup != null) && (reps != 0) && (conn != null)){
            try{
                String query = "INSERT INTO " + db + ".dbo.history(Date, muscleGroup, exercise, reps) VALUES ( '" + formattedDate + "', '"+ musclegroup +"' , '"+ exercise +"', " + reps + ")";
                Statement stmt = conn.createStatement();
                stmt.execute(query);}

            catch (SQLException e) {

                e.printStackTrace();
            }
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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
