package com.workout;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExcerciseLoader {

	public List<Exercise> loadExercies(WorkoutArguments workoutArguments) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		try {
			List<DefaultExercise> exercises = Arrays.asList(mapper.readValue(workoutArguments.getExerciseInput(), DefaultExercise[].class));
			//TODO - hack to avoid generics issues
			ArrayList<Exercise> copy = new ArrayList<Exercise>(exercises);
			return copy;
		} catch (JsonParseException e) {
			System.err.println("Unable to parse file ");
			e.printStackTrace();
			throw new RuntimeException("Unable to parse file ");
		} catch (JsonMappingException e) {
			System.err.println("Unable to parse file ");
			e.printStackTrace();
			throw new RuntimeException("Unable to parse file ");
		} catch (IOException e) {
			System.err.println("Unable to load file ");
			e.printStackTrace();
			throw new RuntimeException("Unable to load file ");
		}
	}

}
