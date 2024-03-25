package com.workout;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;


public class SimpleExerciseLoaderTest {

    protected static class ExtendedSimpleExerciseLoader extends SimpleExerciseLoader{

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

    @Test
    public void readExercises() {
        Resources res = mock(Resources.class);
        AssetManager assets = mock(AssetManager.class);
        ExtendedSimpleExerciseLoader loader = new ExtendedSimpleExerciseLoader(res, assets);
        List<Exercise> exercises = loader.loadExercises();
        assertFalse(exercises.isEmpty());
    }

    @Test
    public void getNeededEquipment() {
        Resources res = mock(Resources.class);
        AssetManager assets = mock(AssetManager.class);
        ExtendedSimpleExerciseLoader loader = new ExtendedSimpleExerciseLoader(res, assets);
        List<Exercise> exercises = loader.loadExercises();
        Set<Equipment> neededEquipment = loader.getEquipmentNeeded(exercises);
        assertFalse(neededEquipment.isEmpty());
    }

}