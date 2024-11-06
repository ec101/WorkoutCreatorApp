package com.workout;

import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

class ExtendedSimpleExerciseLoader extends SimpleExerciseLoader {

    public ExtendedSimpleExerciseLoader(Resources res, AssetManager assets) {
        super(res, assets);
    }

    @Override
    public List<Exercise> loadExercises() {
        File file = new File("C:\\Users\\eclarke\\StudioProjects\\WorkoutCreatorApp\\app\\src\\main\\assets\\exercises.json");
        InputStream input;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Exercise> exercises = readExercises(input);

        try {
            input.close();
        } catch (Exception e) {
            System.err.println("Error closing file");
        }

        return exercises;
    }

}
