package com.workout;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import android.content.res.AssetManager;
import android.content.res.Resources;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class WorkoutCreatorTest {

    private List<Exercise> exercises;

    @Before
    public void setUp() {
        exercises = new ArrayList<>();
        exercises.add(new DefaultExercise("Alt-Single Leg Box Squats", "", new String[]{"LEGS"}, new String[]{"CHAIR"}));
        exercises.add(new DefaultExercise("1 & 1/2 Bottom out Squats w/ Kettle Bell","",new String[]{"LEGS"}, new String[]{"KETTLE_BELL"}));
        exercises.add(new DefaultExercise("Air squats w/ twist jump","",new String[]{"LEGS"}, new String[]{}));
        exercises.add(new DefaultExercise("Jump squats w/ Kettle Bell","",new String[]{"LEGS"}, new String[]{"KETTLE_BELL"}));
        exercises.add(new DefaultExercise("Heel touch squats alternate single leg","",new String[]{"LEGS"}, new String[]{"KETTLE_BELL"}));
        exercises.add(new DefaultExercise("Alternate sprinter lunge w/ Kettle Bell","",new String[]{"LEGS"}, new String[]{"KETTLE_BELL"}));
        exercises.add(new DefaultExercise("Unilateral loaded lunge w/ Kettle Bell (swap round 2)","",new String[]{"LEGS"}, new String[]{"KETTLE_BELL"}));
    }

    @After
    public void tearDown() {

    }

    @Test
    public void workoutCreation() {
        WorkoutCreator workoutCreator = new WorkoutCreator();
        WorkoutArguments workoutArgs = new WorkoutArguments(new ArrayList<>(), new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND)));
        Workout workout = workoutCreator.createWorkout(workoutArgs, exercises);
        assertTrue(!workout.getExercises().isEmpty());
    }
}