package com.workout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkoutArguments {

	public static final WorkoutArguments STANDARD_WORKOUT_1 = new  WorkoutArguments(15, new String[]{"PUSH", "LEGS", "CARDIO", "PULL", "LEGS", "CARDIO", "PUSH", "LEGS", "CARDIO", "PULL", "LEGS", "CARDIO", "ABS", "ABS", "ABS"});

	public static final WorkoutArguments STANDARD_WORKOUT_2 = new  WorkoutArguments(16, new String[]{"PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS", "PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS"});


	private int numberOfExercises;
	private List<String> workoutPattern;

	public WorkoutArguments(int numberOfExercises, String[] args) {
		this.numberOfExercises = numberOfExercises;
		workoutPattern = Arrays.asList(args);
	}

	public WorkoutArguments(int numberOfExercises, List<String> workoutPattern) {
		super();
		this.numberOfExercises = numberOfExercises;
		this.workoutPattern = workoutPattern;
	}

	public int getNumberOfExercises() {
		return numberOfExercises;
	}

	public List<String> getWorkoutPattern() {
		return workoutPattern;
	}

	public boolean hasWorkoutPattern() {
		return workoutPattern != null && workoutPattern.size() > 0;
	}

}
