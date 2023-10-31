package com.workout;


import java.util.Arrays;
import java.util.List;

public class WorkoutArguments {

	public static WorkoutArguments WORKOUT_ARGS = new  WorkoutArguments(16, new String[]{"PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS", "PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS"}, true, true, true);

	private final int numberOfExercises;
	private final List<String> workoutPattern;
	private boolean kettleBell;
	private boolean resistanceBand;
	private boolean spaceRestrictions;

	public WorkoutArguments(int numberOfExercises, String[] workoutPattern, boolean kettleBell, boolean resistanceBand, boolean spaceRestrictions) {
		this.numberOfExercises = numberOfExercises;
		this.workoutPattern = Arrays.asList(workoutPattern);
		this.kettleBell = kettleBell;
		this.resistanceBand = resistanceBand;
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

	public boolean isKettleBell(){
		return kettleBell;
	}

	public boolean isResistanceBand(){
		return resistanceBand;
	}

	public boolean isSpaceRestrictions() {
		return spaceRestrictions;
	}

	public void setKettleBell(boolean value){
		this.kettleBell = value;
	}

	public void setResistanceBand(boolean value){
		this.resistanceBand = value;
	}

	public void setSpaceRestrictions(boolean value){
		this.spaceRestrictions = value;
	}
}
