package com.workout;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import java.util.ArrayList;

public class WorkoutCreatorTest {

    private List<Exercise> exercises;

    @Before
    public void setUp() {
        exercises = new ArrayList<>();
        exercises.add(new DefaultExercise("Alt-Single Leg Box Squats", "", new String[]{"LEGS"}, new String[]{"Chair"}));
        exercises.add(new DefaultExercise("1 & 1/2 Bottom out Squats w/ Kettle Bell","",new String[]{"LEGS"}, new String[]{"KettleBell"}));
        exercises.add(new DefaultExercise("Air squats w/ twist jump","",new String[]{"LEGS"}, new String[]{}));
        exercises.add(new DefaultExercise("Jump squats w/ Kettle Bell","",new String[]{"LEGS"}, new String[]{"KettleBell"}));
        exercises.add(new DefaultExercise("Heel touch squats alternate single leg","",new String[]{"LEGS"}, new String[]{"KettleBell"}));
        exercises.add(new DefaultExercise("Alternate sprinter lunge w/ Kettle Bell","",new String[]{"LEGS"}, new String[]{"KettleBell"}));
        exercises.add(new DefaultExercise("Unilateral loaded lunge w/ Kettle Bell (swap round 2)","",new String[]{"LEGS"}, new String[]{"KettleBell"}));
    }

    @After
    public void tearDown() {

    }

    @Test
    public void workoutCreationTest() {
        WorkoutCreator workoutCreator = new WorkoutCreator();
        WorkoutArguments workoutArgs = new WorkoutArguments(new ArrayList<>(), new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND)));
        Workout workout = workoutCreator.createWorkout(workoutArgs, exercises);
        assertTrue(!workout.getExercises().isEmpty());
    }

    @Test
    public void workoutEquipmentTest() {
        WorkoutCreator workoutCreator = new WorkoutCreator();
        WorkoutArguments workoutArgs = new WorkoutArguments(new ArrayList<>(), new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL)));
        Workout workout = workoutCreator.createWorkout(workoutArgs, exercises);
        //TODO assert that exercises in workout only need kettle bell (or nothing)
        for(Exercise exercise : workout.getExercises()){
            List<Equipment> equipment = exercise.getNeededEquipment();
            assertTrue(equipment.isEmpty() || (equipment.size() == 1 && equipment.contains(Equipment.KETTLE_BELL)));
        }
    }

    @Test
    public void emptyWorkoutEquipmentTest() {
        WorkoutCreator workoutCreator = new WorkoutCreator();
        WorkoutArguments workoutArgs = new WorkoutArguments(new ArrayList<>(), new HashSet<>(Arrays.asList(Equipment.RESISTANCE_BAND)));
        Workout workout = workoutCreator.createWorkout(workoutArgs, exercises);
        //TODO assert that only exercise needing no exercises are returned
        assertTrue(workout.getExercises().isEmpty());
    }

    @Test
    public void workoutPatternTest() {
        WorkoutCreator workoutCreator = new WorkoutCreator();
        ArrayList<String> workoutPattern = new ArrayList<>();
        WorkoutArguments workoutArgs = new WorkoutArguments(workoutPattern, new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND)));
        Workout workout = workoutCreator.createWorkout(workoutArgs, exercises);
        //TODO assert that workout pattern is respected
        assertTrue(workout.getExercises().isEmpty());
    }

    @Test
    public void emptyWorkoutPatternTest() {
        WorkoutCreator workoutCreator = new WorkoutCreator();
        ArrayList<String> workoutPattern = new ArrayList<>();
        WorkoutArguments workoutArgs = new WorkoutArguments(workoutPattern, new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND)));
        Workout workout = workoutCreator.createWorkout(workoutArgs, exercises);
        //TODO assert that workout contains default number of exercises
        assertTrue(workout.getExercises().isEmpty());
    }
}