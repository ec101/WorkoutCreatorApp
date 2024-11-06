package com.workout;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class DefaultWorkoutPrinterTest {

    private List<Exercise> exercises;

    @Before
    public void setUp() {
        exercises = new ArrayList<>();
        exercises.add(new DefaultExercise("Alt-Single Leg Box Squats", "", new String[]{"LEGS"}, new String[]{"Chair"}));
        exercises.add(new DefaultExercise("1 & 1/2 Bottom out Squats w/ Kettle Bell", "", new String[]{"LEGS"}, new String[]{"KettleBell"}));
        exercises.add(new DefaultExercise("Air squats w/ twist jump", "", new String[]{"LEGS"}, new String[]{}));
        exercises.add(new DefaultExercise("Jump squats w/ Kettle Bell", "", new String[]{"LEGS"}, new String[]{"KettleBell"}));
        exercises.add(new DefaultExercise("Heel touch squats alternate single leg", "", new String[]{"LEGS"}, new String[]{"KettleBell"}));
        exercises.add(new DefaultExercise("Alternate sprinter lunge w/ Kettle Bell", "", new String[]{"LEGS"}, new String[]{"KettleBell"}));
        exercises.add(new DefaultExercise("Unilateral loaded lunge w/ Kettle Bell (swap round 2)", "", new String[]{"LEGS"}, new String[]{"KettleBell"}));
        exercises.add(new DefaultExercise("Plyo / Jump sprinter lunge w/ Kettle Bell", "", new String[]{"CARDIO"}, new String[]{"KETTLE_BELL"}));
        exercises.add(new DefaultExercise("Burpees w/ pushup", "", new String[]{"PUSH"}, new String[]{}));
    }

    @After
    public void tearDown() {

    }

    @Test
    public void workoutPrinterTest() {
        WorkoutCreator workoutCreator = new WorkoutCreator();
        WorkoutArguments workoutArgs = new WorkoutArguments(16, new WorkoutPattern(), new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND)));
        Workout workout = workoutCreator.createWorkout(workoutArgs, exercises);
        DefaultWorkoutPrinter printer = new DefaultWorkoutPrinter();
        String workoutAsText = printer.printWorkout(workout);
        assertFalse(workoutAsText.isEmpty());
    }

    @Test
    public void emptyWorkoutPrinterTest() {
        WorkoutCreator workoutCreator = new WorkoutCreator();
        WorkoutArguments workoutArgs = new WorkoutArguments(0, new WorkoutPattern(), new HashSet<>(List.of(Equipment.RESISTANCE_BAND)));
        Workout workout = workoutCreator.createWorkout(workoutArgs, exercises);
        DefaultWorkoutPrinter printer = new DefaultWorkoutPrinter();
        String workoutAsText = printer.printWorkout(workout);
        assertTrue(workoutAsText.isEmpty());
    }
}