package com.example.jasonhuang.uofcfitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class addExerciseMuscleGroupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_exercise_musclegroup_layout);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Spinner muscleGroupSelection = (Spinner)findViewById(R.id.addExerciseMuscleGroupSpinner);

        muscleGroupSelection.setOnItemSelectedListener(this);

        //Muscle group Spinner
        //This will display the first spinner with all the muscle groups
        //I don't really know how to explain this. Reference is from this video: https://www.youtube.com/watch?v=urQp7KsQhW8
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(addExerciseMuscleGroupActivity.this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.muscleGroupList));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        muscleGroupSelection.setAdapter(myAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner exerciseSelection = (Spinner)findViewById(R.id.addExerciseMuscleExerciseSpinner);

        //What is this? the "parent" is the user selected item from SPINNER 1
        String item = parent.getItemAtPosition(position).toString();

        //If user selected Leg in spinner 1, display the second spinner and its corresponding exercises for legs
        if(item.equals("Leg")){
            ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(addExerciseMuscleGroupActivity.this, android.R.layout.simple_list_item_1,
                    getResources().getStringArray(R.array.legList));
            myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            exerciseSelection.setAdapter(myAdapter2);
        }
        if(item.equals("Arm")){
            ArrayAdapter<String> myAdapter3 = new ArrayAdapter<String>(addExerciseMuscleGroupActivity.this, android.R.layout.simple_list_item_1,
                    getResources().getStringArray(R.array.armList));
            myAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            exerciseSelection.setAdapter(myAdapter3);
        }
        if(item.equals("Back")){
            ArrayAdapter<String> myAdapter4 = new ArrayAdapter<String>(addExerciseMuscleGroupActivity.this, android.R.layout.simple_list_item_1,
                    getResources().getStringArray(R.array.backList));
            myAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            exerciseSelection.setAdapter(myAdapter4);
        }
        if(item.equals("Front Body")){
            ArrayAdapter<String> myAdapter5 = new ArrayAdapter<String>(addExerciseMuscleGroupActivity.this, android.R.layout.simple_list_item_1,
                    getResources().getStringArray(R.array.frontBodyList));
            myAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            exerciseSelection.setAdapter(myAdapter5);
        }

    }

    //The implementation requires this method; just leave it empty
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void confirmButton2(View v){
        Spinner exerciseSelection = (Spinner)findViewById(R.id.addExerciseMuscleExerciseSpinner);
        Spinner muscleGroupSelection = (Spinner)findViewById(R.id.addExerciseMuscleGroupSpinner);


        Intent intent = new Intent(this, addExerciseActivity.class);
        intent.putExtra("muscleGroupName2", muscleGroupSelection.getSelectedItem().toString());
        intent.putExtra("exerciseName2", exerciseSelection.getSelectedItem().toString());
        startActivity(intent);

    }
}
