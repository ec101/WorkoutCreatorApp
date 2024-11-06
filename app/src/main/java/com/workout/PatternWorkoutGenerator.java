package com.workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PatternWorkoutGenerator extends AbstractWorkoutGenerator {

	private final Map<String, List<Exercise>> exerciseMap;
	private final Map<String, Iterator<Exercise>> exerciseIteratorMap;
	
	protected PatternWorkoutGenerator(WorkoutArguments args, List<Exercise> exercises) {
		super(args, exercises);
		exerciseMap = initExerciseMap();
		exerciseIteratorMap = new HashMap<>();
	}
	
	private Map<String, List<Exercise>> initExerciseMap() {
		HashMap<String, List<Exercise>> map = new HashMap<>();
		for(Exercise exercise : this.exercises) {
			List<String> types = exercise.getExerciseTypes();
			for(String type : types) {
				List<Exercise> list = map.computeIfAbsent(type, k -> new ArrayList<>());
				//TODO remove this
				if(meetsRequirements(exercise)) {
					list.add(exercise);
				}
			}
		}
		return map;
	}

	public Workout generateSpecificWorkout() {
		DefaultWorkout workout = new DefaultWorkout();
		WorkoutPattern workoutPattern = getWorkoutArguments().getWorkoutPattern();
		for(int i = 0; i < this.getWorkoutArguments().getWorkoutSize(); i++) {
			Exercise nextExercise = getNextExercise(workoutPattern.getNextWorkoutType());
			if(nextExercise != null) {
				workout.addExercise(nextExercise);
			}
		}
		return workout;
	}

	private Exercise getNextExercise(String type) {
		Iterator<Exercise> iterator = exerciseIteratorMap.get(type);
		if(iterator == null || !iterator.hasNext()) {
			List<Exercise> exerciseList = exerciseMap.get(type);
			if(exerciseList!= null) {
				Collections.shuffle(exerciseList, new Random(System.currentTimeMillis()));
				iterator = exerciseList.iterator();
				exerciseIteratorMap.put(type, iterator);
			}
		}
		if(iterator != null && iterator.hasNext()) {
			return iterator.next();
		}
		return null;
	}
}
