package com.workout;

import java.util.List;

public interface Exercise {

	String getName();
	
	String getDescription();
	
	List<String> getExerciseTypes();
	
	boolean isOfType(String type);

	List<String> getNeededEquipment();

	boolean isSpaceNeeded();
}
