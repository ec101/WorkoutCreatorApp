package com.workout;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkoutArguments {

	private static final int DEFAULT_WORKOUT_SIZE = 20;
	public static final WorkoutArguments PATTERN_WORKOUT_ARGUMENTS = new WorkoutArguments(DEFAULT_WORKOUT_SIZE, new WorkoutPattern(), new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND)));
	public static final WorkoutArguments SIMPLE_WORKOUT_ARGUMENTS = new WorkoutArguments(25, null, new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND)));

	private final Set<Equipment> equipmentNeeded;
	private final WorkoutPattern workoutPattern;
	private int workoutSize;

	public WorkoutArguments(int workoutSize, WorkoutPattern workoutPattern, Set<Equipment> equipmentNeeded) {
		this.workoutPattern = workoutPattern;
		this.equipmentNeeded = equipmentNeeded;
		this.workoutSize = workoutSize;
	}

	public WorkoutPattern getWorkoutPattern() {
		return workoutPattern;
	}
	public Set<Equipment> getEquipmentNeeded() { return equipmentNeeded; }
	public boolean hasWorkoutPattern() {
		return workoutPattern != null;
	}
	public int getWorkoutSize() { return workoutSize; }

	public void setWorkoutSize(int size){
		this.workoutSize = size;
	}
}
