package com.example.jasonhuang.uofcfitnessapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Max on 2017-06-15.
 */

public class addExerciseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_exercise_layout);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addExerciseButton(View v){
        Intent intent = new Intent(this, addExerciseMuscleGroupActivity.class);
        startActivity(intent);
    }
}
