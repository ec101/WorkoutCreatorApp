package com.workout;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkoutArguments {

	public static List<String> WORKOUT_PATTERN = Arrays.asList(new String[]{"PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS", "PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS"});
	private static final WorkoutArguments WORKOUT_ARGUMENTS = new WorkoutArguments(WORKOUT_PATTERN, new HashSet<>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND)));
	private final List<String> workoutPattern;
	private final Set<Equipment> equipmentNeeded;

	public WorkoutArguments(List<String> workoutPattern, Set<Equipment> equipmentNeeded) {
		this.workoutPattern = workoutPattern;
		this.equipmentNeeded = equipmentNeeded;
	}

	public static WorkoutArguments getInstance(){
		return WORKOUT_ARGUMENTS;
	}
	public List<String> getWorkoutPattern() {
		return workoutPattern;
	}

	public Set<Equipment> getEquipmentNeeded() { return equipmentNeeded; }

	public void setEquipmentNeeded(Equipment equipment){
		this.equipmentNeeded.add(equipment);
	}

	public boolean hasWorkoutPattern() {
		return workoutPattern != null && !workoutPattern.isEmpty();
	}
}
