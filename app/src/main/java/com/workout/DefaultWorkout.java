package com.workout;

import java.util.ArrayList;
import java.util.List;

public class DefaultWorkout implements Workout {

	private List<Exercise> exercises;
	
	public DefaultWorkout() {
		super();
		this.exercises = new ArrayList<Exercise>();
	}

	public void addExercise(Exercise exercise) {
		this.exercises.add(exercise);
	}
	
	public List<Exercise> getExercises() {
		return exercises;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(Exercise exercise : exercises) {
			builder.append(exercise.toString()+"\n");
		}
		return builder.toString();
		
	}
}
