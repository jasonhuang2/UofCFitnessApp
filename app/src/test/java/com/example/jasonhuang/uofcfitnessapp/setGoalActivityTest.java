package com.example.jasonhuang.uofcfitnessapp;

import android.os.StrictMode;
import android.util.Log;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.Assert.*;

/**
 * Created by jasonhuang on 2017-06-16.
 */
public class setGoalActivityTest {



    @Test
    public void testConnection() throws Exception{
      setGoalActivity asdf = new setGoalActivity();
        assertNotEquals(asdf.getConnection(), null);
    }

    @Test
    public void testReturnedDate() throws Exception{
        setGoalActivity test = new setGoalActivity();
        assertNotEquals(test.returnGdate(), null);
    }

    @Test
    public void testReturnedMuscleGroup() throws Exception{
        setGoalActivity test = new setGoalActivity();
        assertNotEquals(test.returnMuscleGroup(), null);
    }
    @Test
    public void testReturnMuscleExercise() throws Exception{
        setGoalActivity test = new setGoalActivity();
        assertNotEquals(test.returnMuscle(), null);
    }

}