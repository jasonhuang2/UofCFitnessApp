package com.example.jasonhuang.uofcfitnessapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.example.jasonhuang.uofcfitnessapp.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Connection conn;
    String un, pass, db, ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_activity);

        //NOTE: Fill these attributes before you execute this program
        //NOTE: For ip address, if you are provided with a port number, the format will be "ipaddress:portnumber"
        ip = "sql5023.smarterasp.net";    //enter ip address here
        db = "DB_A263B4_test";    //emter database name here
        un = "DB_A263B4_test_admin";    //enter username here
        pass = "nightonfire123";  //enter password here

        TextView quoteBox = (TextView)findViewById(R.id.quoteBox);
        conn = connectionclass(un, pass, db, ip);
        if(conn == null){
            quoteBox.setText("CONNECTION FAILED");}
        else{    try {
                Random rand = new Random();
                int var1 = rand.nextInt(16) + 1;
                //Inserting into the database with db = database name
                //dbo.names is the table name
                //standard format for accessing the sql server provided through Tamer is the following
                String query = "SELECT * FROM " + db + ".dbo.quotes WHERE id = "+var1+";";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.next() == true){
                    String quote1 = rs.getString("quote");
                quoteBox.setText(quote1);}
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    //connection class
    @SuppressLint("NewApi")
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

    public void setGoalButton(View v){
        Intent intent = new Intent(this, setGoalActivity.class);
        startActivity(intent);
    }
    public void setReminderButton(View v){
        Intent intent1 = new Intent(this, setReminderActivity.class);
        startActivity(intent1);
    }
}
