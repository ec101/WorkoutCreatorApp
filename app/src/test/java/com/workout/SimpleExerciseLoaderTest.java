package com.workout;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import android.content.res.AssetManager;
import android.content.res.Resources;

import org.junit.Test;

import java.util.List;


public class SimpleExerciseLoaderTest {

    @Test
    public void readExercises() {
        Resources res = mock(Resources.class);
        AssetManager assets = mock(AssetManager.class);
        ExtendedSimpleExerciseLoader loader = new ExtendedSimpleExerciseLoader(res, assets);
        List<Exercise> exercises = loader.loadExercises();
        assertFalse(exercises.isEmpty());
    }

}