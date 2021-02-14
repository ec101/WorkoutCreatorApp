package com.example.workoutcreatorapp;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import com.workout.DefaultWorkoutPrinter;
import com.workout.ExcerciseLoader;
import com.workout.Exercise;
import com.workout.Workout;
import com.workout.WorkoutArguments;
import com.workout.WorkoutCreator;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ExcerciseLoader loader = new ExcerciseLoader();
        List<Exercise> exercises = loader.loadExercies(getAssets());

        WorkoutCreator workoutCreator = new WorkoutCreator();
        Workout workout = workoutCreator.createWorkout(WorkoutArguments.DEFAULT_ARGS, exercises);

        DefaultWorkoutPrinter printer = new DefaultWorkoutPrinter();
        String workoutAsText = printer.printWorkout(workout);

        TextView textView = new TextView(this);
        textView.setText(workoutAsText);
        setContentView(textView);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}