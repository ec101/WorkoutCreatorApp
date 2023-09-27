package com.workout;

import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.workoutcreatorapp.R;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class SimpleExerciseLoader implements ExerciseLoader{

	private final Resources res;
	private final AssetManager assets;

	public SimpleExerciseLoader(Resources res, AssetManager assets){
		super();
		this.res = res;
		this.assets = assets;
	}

	@Override
	public List<Exercise> loadExercies() {
		InputStream input = null;

		try {
			input = assets.open("exercises.json");
		} catch (IOException e) {
			System.err.println(res.getString(R.string.open_file));
		}

		List<Exercise> exercises = readExercises(input);

		try {
			if(input !=null) {
				input.close();
			}
		} catch (Exception e) {
			System.err.println(res.getString(R.string.close_file));
		}

		return exercises;
	}

	protected List<Exercise> readExercises(InputStream input){
		ObjectMapper mapper = new ObjectMapper();
		try {
			return Arrays.asList(mapper.readValue(input, DefaultExercise[].class));
		} catch (JsonParseException e) {
			System.err.println(res.getString(R.string.parse_file));
		} catch (JsonMappingException e) {
			System.err.println(res.getString(R.string.parse_file));
		} catch (IOException e) {
			System.err.println(res.getString(R.string.load_file));
		}
		return new ArrayList<Exercise>();
	}
}
