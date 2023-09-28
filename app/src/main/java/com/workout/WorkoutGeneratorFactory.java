package com.workout;

import java.util.List;

public interface WorkoutGeneratorFactory {

	WorkoutGenerator newWorkoutGenerator(WorkoutArguments workoutArguments, List<Exercise> exercises);
	
}
