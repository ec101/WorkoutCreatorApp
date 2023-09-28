package com.workout;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class DefaultWorkout implements Workout {

	private final List<Exercise> exercises;
	
	public DefaultWorkout() {
		super();
		this.exercises = new ArrayList<>();
	}

	public void addExercise(Exercise exercise) {
		this.exercises.add(exercise);
	}
	
	public List<Exercise> getExercises() {
		return exercises;
	}

	@Override
	public boolean contains(Exercise exercise) {
		return this.exercises.contains(exercise);
	}

	@NonNull
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(Exercise exercise : exercises) {
			builder.append(exercise.toString()).append("\n");
		}
		return builder.toString();
	}
}
