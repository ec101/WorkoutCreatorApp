package com.workout;

import java.util.List;

public interface WorkoutGeneratorFactory {

	public WorkoutGenerator newWorkoutGenerator(WorkoutArguments workoutArguments, List<Exercise> exercises);
	
}
