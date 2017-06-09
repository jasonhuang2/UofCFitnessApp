package com.example.jasonhuang.uofcfitnessapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class muscleGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.muscle_group_layout);

        //For the back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Spinner muscleGroupSelection = (Spinner)findViewById(R.id.muscleGroupSpinner);
        Spinner exerciseSelection = (Spinner)findViewById(R.id.exerciseGroupSpinner);

        //Muscle group Spinner
        //I don't really know how to explain this. Reference is from this video: https://www.youtube.com/watch?v=urQp7KsQhW8
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(muscleGroupActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.muscleGroupList));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        muscleGroupSelection.setAdapter(myAdapter);

        //Cases
        if(muscleGroupSelection.getSelectedItem().toString().equals("Leg")){
            ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(muscleGroupActivity.this, android.R.layout.simple_list_item_1,
                    getResources().getStringArray(R.array.legList));
            myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            exerciseSelection.setAdapter(myAdapter2);
        }
        if(muscleGroupSelection.getSelectedItem().toString().equals("Arm")){
            ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(muscleGroupActivity.this, android.R.layout.simple_list_item_1,
                    getResources().getStringArray(R.array.armList));
            myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            exerciseSelection.setAdapter(myAdapter3);
        }

    }
}
