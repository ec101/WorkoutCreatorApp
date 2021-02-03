package com.workout;

import java.util.List;

public class DefaultWorkoutGeneratorFactory implements WorkoutGeneratorFactory {

	public DefaultWorkoutGeneratorFactory() {
		super();
	}
	
	public WorkoutGenerator newWorkoutGenerator(WorkoutArguments workoutArguments, List<Exercise> exercises) {
		if(workoutArguments.hasWorkoutPattern()) {
			return new PatternWorkoutGenerator(workoutArguments, exercises);
		}
		return new SimpleWorkoutGenerator(workoutArguments, exercises);
	}

}
