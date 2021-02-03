package com.workout;

import java.util.List;

public abstract class AbstractWorkoutGenerator implements WorkoutGenerator {

	protected final WorkoutArguments args;

	protected final List<Exercise> exercises;
	
	protected AbstractWorkoutGenerator(WorkoutArguments args, List<Exercise> exercises) {
		this.args = args;
		this.exercises = exercises;
	}

	protected WorkoutArguments getWorkoutArguments() {
		return args;
	}

}
