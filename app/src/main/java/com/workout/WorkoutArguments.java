package com.workout;


import java.util.Arrays;
import java.util.List;

public class WorkoutArguments {

	public static final WorkoutArguments STANDARD_WORKOUT_1 = new  WorkoutArguments(15, new String[]{"PUSH", "LEGS", "CARDIO", "PULL", "LEGS", "CARDIO", "PUSH", "LEGS", "CARDIO", "PULL", "LEGS", "CARDIO", "ABS", "ABS", "ABS"}, new String[]{}, false);

	public static final WorkoutArguments STANDARD_WORKOUT_2 = new  WorkoutArguments(16, new String[]{"PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS", "PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS"}, new String[]{}, false);

	public static final WorkoutArguments TRAVEL_WORKOUT = new  WorkoutArguments(16, new String[]{"PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS", "PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS"}, new String[]{"Resistance Band"}, true);

	private final int numberOfExercises;
	private final List<String> workoutPattern;
	private final List<String> equipment;
	private final boolean spaceRestrictions;

	public WorkoutArguments(int numberOfExercises, String[] workoutPattern, String[] equipment, boolean spaceRestrictions) {
		this.numberOfExercises = numberOfExercises;
		this.workoutPattern = Arrays.asList(workoutPattern);
		this.equipment = Arrays.asList(equipment);
		this.spaceRestrictions = spaceRestrictions;
	}

	public int getNumberOfExercises() {
		return numberOfExercises;
	}

	public List<String> getWorkoutPattern() {
		return workoutPattern;
	}

	public boolean hasWorkoutPattern() {
		return workoutPattern != null && workoutPattern.size() > 0;
	}

	public List<String> getEquipment(){
		return this.equipment;
	}

	public boolean isSpaceRestrictions() {
		return spaceRestrictions;
	}

}
