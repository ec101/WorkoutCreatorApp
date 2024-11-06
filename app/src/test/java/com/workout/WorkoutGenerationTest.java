package com.workout;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import android.content.res.AssetManager;
import android.content.res.Resources;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WorkoutGenerationTest {

    private List<Exercise> exercises;

    @Before
    public void setUp() {

        Resources res = mock(Resources.class);
        AssetManager assets = mock(AssetManager.class);
        ExtendedSimpleExerciseLoader loader = new ExtendedSimpleExerciseLoader(res, assets);
        exercises = loader.loadExercises();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void defaultWorkoutGenerationTest() {
        int workoutSize = 16;
        WorkoutCreator workoutCreator = new WorkoutCreator();
        WorkoutArguments workoutArgs = new WorkoutArguments(workoutSize, new WorkoutPattern(), new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND)));
        Workout workout = workoutCreator.createWorkout(workoutArgs, exercises);
        assertEquals(workout.getExercises().size(), workoutSize);
    }

    @Test
    public void twentyExerciseWorkoutGenerationTest() {
        int workoutSize = 20;
        WorkoutCreator workoutCreator = new WorkoutCreator();
        WorkoutArguments workoutArgs = new WorkoutArguments(workoutSize, new WorkoutPattern(), new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND)));
        Workout workout = workoutCreator.createWorkout(workoutArgs, exercises);
        assertEquals(workout.getExercises().size(), workoutSize);
    }

    @Test
    public void twentyExerciseWorkoutGenerationTestWithLimitedSpace() {
        int workoutSize = 20;
        WorkoutCreator workoutCreator = new WorkoutCreator();
        WorkoutArguments workoutArgs = new WorkoutArguments(workoutSize, new WorkoutPattern(), new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND, Equipment.SPACE)));
        Workout workout = workoutCreator.createWorkout(workoutArgs, exercises);
        assertEquals(workout.getExercises().size(), workoutSize);
    }

}
