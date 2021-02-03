package com.workout;

public interface Exercise {

	String getName();
	
	String getDescription();
	
	String[] getExerciseTypes();
	
	boolean isOfType(String type);
}
