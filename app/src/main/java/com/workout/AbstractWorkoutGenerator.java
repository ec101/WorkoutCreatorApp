package com.workout;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorkoutGenerator implements WorkoutGenerator {

	protected final WorkoutArguments args;

	protected final List<Exercise> exercises;
	
	protected AbstractWorkoutGenerator(WorkoutArguments args, List<Exercise> exercises) {
		this.args = args;
		this.exercises = new ArrayList<>();
		for(Exercise exercise : exercises) {
			if (meetsRequirements(exercise)) {
				this.exercises.add(exercise);
			}
		}
	}

	protected WorkoutArguments getWorkoutArguments() {
		return args;
	}

	public Workout generateWorkout() {
		if(exercises.isEmpty()){
			return new DefaultWorkout();
		}
		return generateSpecificWorkout();
	}

	protected abstract Workout generateSpecificWorkout();

	protected boolean meetsRequirements(Exercise exercise) {
		if(this.getWorkoutArguments().getEquipmentNeeded().contains(Equipment.SPACE)){
			return exercise.getNeededEquipment().contains(Equipment.SPACE);
		}

		if(this.getWorkoutArguments().getEquipmentNeeded().contains(Equipment.KETTLE_BELL)){
			return exercise.getNeededEquipment().contains(Equipment.KETTLE_BELL);
		}

		if(this.getWorkoutArguments().getEquipmentNeeded().contains(Equipment.RESISTANCE_BAND)){
			return exercise.getNeededEquipment().contains(Equipment.RESISTANCE_BAND);
		}

		if(this.getWorkoutArguments().getEquipmentNeeded().contains(Equipment.CHAIR)){
			return exercise.getNeededEquipment().contains(Equipment.CHAIR);
		}

		return true;
	}

}
