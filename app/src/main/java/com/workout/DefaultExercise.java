package com.workout;

import java.util.Arrays;
import java.util.List;

public class DefaultExercise implements Exercise {

	private String name;
	private String description;
	private String[] exerciseTypes;
	private String[]  neededEquipment;

	public DefaultExercise() {
	}
	
	public DefaultExercise(String name, String description, String[] exerciseTypes, String[]  neededEquipment) {
		this.name = name;
		this.description = description;
		this.exerciseTypes = exerciseTypes;
		this.neededEquipment = neededEquipment;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getExerciseTypes() {
		return Arrays.asList(exerciseTypes);
	}

	public boolean isOfType(String type) {
		if(type == null || type.isEmpty()) {
			return false;
		}
		if(exerciseTypes == null || exerciseTypes.length == 0) {
			return false;
		}
		for(String eType : exerciseTypes) {
			if(eType.equalsIgnoreCase(type)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<String> getNeededEquipment() {
		return Arrays.asList(neededEquipment);
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("name: "+name+", ");
		if(!description.isEmpty()) {
			builder.append("description: "+description+", ");
		}
		builder.append("type(s): ");
		for(String type : exerciseTypes) {
			builder.append(type+" ");
		}
		builder.append("needed equipment: ");
		for(String equipment : this.neededEquipment) {
			builder.append(equipment+" ");
		}
		return builder.toString();
	}
}
