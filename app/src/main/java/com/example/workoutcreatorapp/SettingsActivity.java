package com.example.workoutcreatorapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import com.workout.DefaultWorkoutPrinter;
import com.workout.Workout;
import com.workout.WorkoutCreator;

import java.io.IOException;
import java.io.InputStream;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.settings_activity);

        WorkoutCreator workoutCreator = new WorkoutCreator();

        Workout workout;
        InputStream input = null;
        try {
            input = getAssets().open("exercises.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] args = {"15", "PUSH", "LEGS", "CARDIO", "PULL", "LEGS", "CARDIO", "PUSH", "LEGS", "CARDIO", "PULL", "LEGS", "CARDIO", "ABS", "ABS", "ABS"};
        workout = workoutCreator.createWorkout(input, args);
        DefaultWorkoutPrinter printer = new DefaultWorkoutPrinter();
        String workoutAsText = printer.printWorkout(workout);

        TextView textView = new TextView(this);
        textView.setText(workoutAsText);
        setContentView(textView);

//        if (savedInstanceState == null) {
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.settings, new SettingsFragment())
//                    .commit();
//        }
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//        }
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}