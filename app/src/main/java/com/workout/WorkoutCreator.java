package com.workout;

import java.io.InputStream;
import java.util.*;

public class WorkoutCreator {

	public Workout createWorkout(WorkoutArguments workoutArguments, List<Exercise> exercises) {
		WorkoutGeneratorFactory workoutGeneratorFactory = new DefaultWorkoutGeneratorFactory();
		WorkoutGenerator workoutGenerator = workoutGeneratorFactory.newWorkoutGenerator(workoutArguments, exercises);
		return workoutGenerator.generateWorkout();
	}
}
