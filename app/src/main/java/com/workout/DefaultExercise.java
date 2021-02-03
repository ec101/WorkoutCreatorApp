package com.workout;

public class DefaultExercise implements Exercise {

	private String name;
	private String description;
	private String[] exerciseTypes;
	
	public DefaultExercise() {
	}
	
	public DefaultExercise(String name, String description, String[] exerciseTypes) {
		this.name = name;
		this.description = description;
		this.exerciseTypes = exerciseTypes;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String[] getExerciseTypes() {
		return exerciseTypes;
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
		return builder.toString();
	}
}
