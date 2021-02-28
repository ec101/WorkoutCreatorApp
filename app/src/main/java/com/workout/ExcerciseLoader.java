package com.workout;

import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.workoutcreatorapp.R;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExcerciseLoader {

	public List<Exercise> loadExercies(Resources res, AssetManager assets) {
		InputStream input = null;
		ArrayList<Exercise> copy = new ArrayList<Exercise>();

		try {
			input = assets.open("exercises.json");
		} catch (IOException e) {
			System.err.println(res.getString(R.string.open_file));
		}

		ObjectMapper mapper = new ObjectMapper();
		try {
			List<DefaultExercise> exercises = Arrays.asList(mapper.readValue(input, DefaultExercise[].class));
			//TODO - hack to avoid generics issues
			copy = new ArrayList<Exercise>(exercises);
		} catch (JsonParseException e) {
			System.err.println(res.getString(R.string.parse_file));
		} catch (JsonMappingException e) {
			System.err.println(res.getString(R.string.parse_file));
		} catch (IOException e) {
			System.err.println(res.getString(R.string.load_file));
		}

		try {
			if(input !=null) {
				input.close();
			}
		} catch (Exception e) {
			System.err.println(res.getString(R.string.close_file));
		}

		return copy;
	}
}
