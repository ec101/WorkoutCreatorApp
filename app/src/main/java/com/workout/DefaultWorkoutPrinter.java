package com.workout;

import java.util.List;

public class DefaultWorkoutPrinter implements WorkoutPrinter {

	private final int grouping;

	public DefaultWorkoutPrinter(int grouping){
		super();
		this.grouping= grouping;
	}

	public String printWorkout(Workout workout) {
		StringBuilder stringBuilder = new StringBuilder();
		List<Exercise> exercises = workout.getExercises();
		for(int i = 0; i < exercises.size(); i++){
			Exercise exercise = exercises.get(i);
			printExercise(i+1, exercise, stringBuilder);
		}
		return stringBuilder.toString();
	}

	private void printExercise(int number, Exercise exercise, StringBuilder stringBuilder) {
		stringBuilder.append(number).append(": ").append(exercise.getName()).append("\n");
		if(number%this.grouping == 0) {
			stringBuilder.append("\n");
		}
	}

}
