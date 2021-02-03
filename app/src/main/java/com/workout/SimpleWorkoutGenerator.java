package com.workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimpleWorkoutGenerator extends AbstractWorkoutGenerator {

	public SimpleWorkoutGenerator(WorkoutArguments args, List<Exercise> exercises) {
		super(args, exercises);
	}

	public Workout generateWorkout() {
		List<Exercise> exercisesCopy = setupExercises(exercises);
		DefaultWorkout workout = new DefaultWorkout();
		for(int i = 0; i < this.getWorkoutArguments().getNumberOfExercises(); i++) {
			Exercise nextExercise = getNextExercise(i, exercisesCopy);
			if(nextExercise != null) {
				workout.addExercise(nextExercise);
			}else {
				System.err.println("Unable to find exercise!");
			}
		}

		return workout;
	}
	
	private  List<Exercise> setupExercises(List<Exercise> exercises) {
		List<Exercise> exercisesCopy = new ArrayList<Exercise>(exercises);
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
