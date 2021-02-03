package com.workout;

import java.io.InputStream;
import java.util.*;

public class WorkoutCreator {

	public Workout createWorkout(InputStream input, String[] args) {
		Workout workout = null;
		try {
			WorkoutArguments workoutArguments = new WorkoutArguments(input, args);

			ExcerciseLoader loader = new ExcerciseLoader();
			
			List<Exercise> exercises = loader.loadExercies(workoutArguments);
			
			WorkoutGeneratorFactory workoutGeneratorFactory = new DefaultWorkoutGeneratorFactory();

			WorkoutGenerator workoutGenerator = workoutGeneratorFactory.newWorkoutGenerator(workoutArguments, exercises);

			workout = workoutGenerator.generateWorkout();

		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return workout;
	}
}
