package com.example.workoutcreatorapp;

import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        setContentView(R.layout.settings_activity);

        Resources res = getResources();
        ExcerciseLoader loader = new ExcerciseLoader();
        List<Exercise> exercises = loader.loadExercies(res, getAssets());

        Button b1= findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                generateWorkout(exercises);
            }
        });

        String workoutAsText = res.getString(R.string.generic_error);

        if(exercises != null && !exercises.isEmpty()) {
            generateWorkout(exercises);
        }else{
            TextView textView = findViewById(R.id.textView);
            textView.setText(workoutAsText);
            b1.setEnabled(false);
        }
    }

    private void generateWorkout(List<Exercise> exercises){
        WorkoutCreator workoutCreator = new WorkoutCreator();
        Workout workout = workoutCreator.createWorkout(WorkoutArguments.DEFAULT_ARGS, exercises);
        DefaultWorkoutPrinter printer = new DefaultWorkoutPrinter();
        String workoutAsText = printer.printWorkout(workout);
        TextView textView = findViewById(R.id.textView);
        textView.setText(workoutAsText);
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey);
        }
    }
}