package com.workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimpleWorkoutGenerator extends AbstractWorkoutGenerator {

	private static final int WORKOUT_SIZE = 16;

	public SimpleWorkoutGenerator(WorkoutArguments args, List<Exercise> exercises) {
		super(args, exercises);
	}

	public Workout generateWorkout() {
		DefaultWorkout workout = new DefaultWorkout();
		if(exercises.isEmpty()){
			return workout;
		}

		List<Exercise> exercisesCopy = shuffleExercises(exercises);
		for(int i = 0; i < WORKOUT_SIZE; i++) {
			Exercise nextExercise = getNextExercise(i, exercisesCopy);
			if(nextExercise != null) {
				workout.addExercise(nextExercise);
			}else {
				System.err.println("Unable to find exercise!");
			}
		}

		return workout;
	}
	
	private  List<Exercise> shuffleExercises(List<Exercise> exercises) {
		List<Exercise> exercisesCopy = new ArrayList<>(exercises);
		Collections.shuffle(exercisesCopy, new Random(System.currentTimeMillis()));
		return exercisesCopy;
	}
	
	private Exercise getNextExercise(int index, List<Exercise> exercises) {
		int i = index;
		if(i >= exercises.size()) {
			i = i % exercises.size();
		}
		return exercises.get(i);
	}

}
