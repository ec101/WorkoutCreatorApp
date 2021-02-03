package com.workout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class WorkoutArguments {

	private InputStream exerciseInput;
	private int numberOfExercises;
	private List<String> workoutPattern;

	public WorkoutArguments(InputStream exerciseInput, String[] args) {
		this.exerciseInput = exerciseInput;
		numberOfExercises = 15;
		workoutPattern = new ArrayList<String>();
		if(args.length > 0){
			if(args[0] != null) {
				numberOfExercises = Integer.valueOf(args[0]).intValue();
			}

			for(int i = 1; i < args.length; i++) {
				workoutPattern.add(args[i]);
			}
		}
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

	public InputStream getExerciseInput() {return exerciseInput; }
}
