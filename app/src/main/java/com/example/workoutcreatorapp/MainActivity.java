package com.example.workoutcreatorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.Intent;
import android.os.Bundle;

import android.content.res.Resources;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.workout.DefaultWorkoutPrinter;
import com.workout.SimpleExerciseLoader;
import com.workout.Exercise;
import com.workout.Workout;
import com.workout.WorkoutArguments;
import com.workout.WorkoutCreator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Exercise> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Resources res = getResources();
        SimpleExerciseLoader loader = new SimpleExerciseLoader(res, getAssets());
        exercises = loader.loadExercises();

        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);

        ActionMenuItemView reloadButton = topAppBar.findViewById(R.id.reload);
        reloadButton.setOnClickListener(v -> generateWorkout(exercises));

        ActionMenuItemView shareButton = topAppBar.findViewById(R.id.share);
        shareButton.setOnClickListener(v -> shareWorkout());

        ActionMenuItemView settingsButton = topAppBar.findViewById(R.id.settings);
        settingsButton.setOnClickListener(v -> launchSettingsActivity());

        String workoutAsText = res.getString(R.string.generic_error);

        if(exercises != null && !exercises.isEmpty()) {
            generateWorkout(exercises);
        }else{
            TextView textView = findViewById(R.id.textView2);
            textView.setText(workoutAsText);
            reloadButton.setEnabled(false);
            shareButton.setEnabled(false);
        }
    }

    private void shareWorkout(){
        TextView textView = findViewById(R.id.textView2);
        String workout = textView.getText().toString();
        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        myIntent.putExtra(Intent.EXTRA_SUBJECT,"Workout");
        myIntent.putExtra(Intent.EXTRA_TEXT,workout);
        startActivity(Intent.createChooser(myIntent, "Share Using"));
    }

    private void launchSettingsActivity(){
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    private void generateWorkout(List<Exercise> exercises) {
        WorkoutCreator workoutCreator = new WorkoutCreator();
        Workout workout = workoutCreator.createWorkout(WorkoutArguments.WORKOUT_ARGS, exercises);
        DefaultWorkoutPrinter printer = new DefaultWorkoutPrinter(4);
        String workoutAsText = printer.printWorkout(workout);
        TextView textView = findViewById(R.id.textView2);
        textView.setText(workoutAsText);
    }
}