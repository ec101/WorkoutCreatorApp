package com.workout;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultExercise implements Exercise {

	private String name;
	private String description;
	private String[] exerciseTypes;
	private List<Equipment> neededEquipment;

	public DefaultExercise(){
	}

	public DefaultExercise(String name, String description, String[] exerciseTypes, String[] neededEquipment) {
		this.name = name;
		this.description = description;
		this.exerciseTypes = exerciseTypes;
		this.neededEquipment = new ArrayList<Equipment>();
		for(String equipment : neededEquipment){
			Equipment equ = Equipment.getEquipment(equipment);
			if(equ != null) {
				this.neededEquipment.add(equ);
			}
		}
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
	public List<Equipment> getNeededEquipment() {
		return neededEquipment;
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
		for(Equipment equipment : this.neededEquipment) {
			//TODO - will end up with comma as last character
			builder.append(equipment.getName()).append(",");
		}
		return builder.toString();
	}
}
