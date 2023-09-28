package com.workout;

import androidx.annotation.NonNull;

import java.util.Arrays;
import java.util.List;

public class DefaultExercise implements Exercise {

	private String name;
	private String description;
	private String[] exerciseTypes;
	private String[]  neededEquipment;
	private boolean spaceNeeded;

	public DefaultExercise(){
	}

	public DefaultExercise(String name, String description, String[] exerciseTypes, String[]  neededEquipment, boolean spaceNeeded) {
		this.name = name;
		this.description = description;
		this.exerciseTypes = exerciseTypes;
		this.neededEquipment = neededEquipment;
		this.spaceNeeded = spaceNeeded;
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

	public boolean isSpaceNeeded() {
		return spaceNeeded;
	}

	public boolean isOfType(String type) {
		if(type == null || type.isEmpty()) {
			return false;
		}
		if(exerciseTypes == null) {
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

	@NonNull
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("name: ").append(name).append(", ");
		if(!description.isEmpty()) {
			builder.append("description: ").append(description).append(", ");
		}
		builder.append("type(s): ");
		for(String type : exerciseTypes) {
			builder.append(type).append(" ");
		}
		builder.append("needed equipment: ");
		for(String equipment : this.neededEquipment) {
			builder.append(equipment).append(" ");
		}
		builder.append("space Needed: ");
		if(isSpaceNeeded()){
			builder.append("yes");
		}else{
			builder.append("no");
		}
		return builder.toString();
	}
}
