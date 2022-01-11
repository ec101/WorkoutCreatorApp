package com.workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PatternWorkoutGenerator extends AbstractWorkoutGenerator {

	private Map<String, List<Exercise>> exerciseMap;
	private Map<String, Iterator<Exercise>> exerciseIteratorMap;
	
	protected PatternWorkoutGenerator(WorkoutArguments args, List<Exercise> exercises) {
		super(args, exercises);
		exerciseMap = initExerciseMap();
		exerciseIteratorMap = new HashMap<String, Iterator<Exercise>>();
	}
	
	private Map<String, List<Exercise>> initExerciseMap() {
		HashMap<String, List<Exercise>> map = new HashMap<String, List<Exercise>>();
		for(Exercise exercise : this.exercises) {
			String[] types = exercise.getExerciseTypes();
			for(String type : types) {
				List<Exercise> list = map.get(type);
				if(list == null) {
					list = new ArrayList<Exercise>();
					map.put(type, list);
				}
				list.add(exercise);
			}
		}
		return map;
	}

	public Workout generateWorkout() {
		DefaultWorkout workout = new DefaultWorkout();
		for(int i = 0; i < this.getWorkoutArguments().getNumberOfExercises(); i++) {
			String type = getNextExerciseType(i);
			addNextExercise(type, workout);
		}
		return workout;
	}

	private void addNextExercise(String type, DefaultWorkout workout) {
		boolean addedExercise = false;
		int count = 0;
		while(!addedExercise && count < 3) {
			Exercise nextExercise = getNextExercise(type);
			if (!workout.contains(nextExercise)) {
				workout.addExercise(nextExercise);
				addedExercise = true;
			}
			count++;
		}
	}

	private Exercise getNextExercise(String type) {
		Iterator<Exercise> iterator = exerciseIteratorMap.get(type);
		if(iterator == null || !iterator.hasNext()) {
			List<Exercise> exerciseList = exerciseMap.get(type);
			Collections.shuffle(exerciseList, new Random(System.currentTimeMillis()));
			iterator = exerciseList.iterator();
			exerciseIteratorMap.put(type, iterator);
		}
		return iterator.next();
	}

	private String getNextExerciseType(int index) {
		String type = "";
		if(index >= getWorkoutArguments().getWorkoutPattern().size()) {
			int i = index % getWorkoutArguments().getWorkoutPattern().size();
			type = getWorkoutArguments().getWorkoutPattern().get(i);
		} else {
			type = getWorkoutArguments().getWorkoutPattern().get(index);
		}
		return type;
	}

}
