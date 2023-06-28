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
			List<String> types = exercise.getExerciseTypes();
			for(String type : types) {
				List<Exercise> list = map.get(type);
				if(list == null) {
					list = new ArrayList<Exercise>();
					map.put(type, list);
				}
				if(this.getWorkoutArguments().getEquipment().isEmpty() ||
						this.getWorkoutArguments().getEquipment().containsAll(exercise.getNeededEquipment())) {
					list.add(exercise);
				}
			}
		}
		return map;
	}

	public Workout generateWorkout() {
		DefaultWorkout workout = new DefaultWorkout();
		Iterator<String> patternIterator = getWorkoutArguments().getWorkoutPattern().iterator();
		for(int i = 0; i < this.getWorkoutArguments().getNumberOfExercises() && patternIterator.hasNext(); i++) {
			Exercise nextExercise = getNextExercise(patternIterator.next());
			workout.addExercise(nextExercise);
			if(!patternIterator.hasNext()){
				patternIterator = getWorkoutArguments().getWorkoutPattern().iterator();
			}
		}
		return workout;
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
}
