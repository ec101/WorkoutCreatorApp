package com.workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimpleWorkoutGenerator extends AbstractWorkoutGenerator {

	private static final int WORKOUT_SIZE = 25;

	public SimpleWorkoutGenerator(WorkoutArguments args, List<Exercise> exercises) {
		super(args, exercises);
	}

	protected Workout generateSpecificWorkout() {
		DefaultWorkout workout = new DefaultWorkout();
		List<Exercise> exercisesCopy = shuffleExercises(exercises);
		for(int i = 0; i < WORKOUT_SIZE; i++) {
			Exercise nextExercise = exercisesCopy.remove(0);
			if(nextExercise != null) {
				workout.addExercise(nextExercise);
			}else {
				System.err.println("Unable to find exercise!");
			}
			exercisesCopy.add(nextExercise);
		}

		return workout;
	}
	
	private  List<Exercise> shuffleExercises(List<Exercise> exercises) {
		List<Exercise> exercisesCopy = new ArrayList<>(exercises);
		Collections.shuffle(exercisesCopy, new Random(System.currentTimeMillis()));
		return exercisesCopy;
	}
}
