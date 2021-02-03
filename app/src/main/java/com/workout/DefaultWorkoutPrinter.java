package com.workout;

import java.util.List;

public class DefaultWorkoutPrinter implements WorkoutPrinter {

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
		stringBuilder.append(number+": "+exercise.getName()+"\n");
		if(number%3 == 0) {
			stringBuilder.append("\n");
		}
	}

}
