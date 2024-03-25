package com.example.workoutcreatorapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.Intent;
import android.os.Bundle;

import android.content.res.Resources;
import android.widget.TextView;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;
import com.workout.DefaultWorkoutPrinter;
import com.workout.Equipment;
import com.workout.SimpleExerciseLoader;
import com.workout.Exercise;
import com.workout.Workout;
import com.workout.WorkoutArguments;
import com.workout.WorkoutCreator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    public static WorkoutArguments NO_SPACE = new WorkoutArguments(WorkoutArguments.WORKOUT_PATTERN,
            new HashSet<Equipment>(Arrays.asList(Equipment.KETTLE_BELL, Equipment.RESISTANCE_BAND)));
    private List<Exercise> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Resources res = getResources();
        SimpleExerciseLoader loader = new SimpleExerciseLoader(res, getAssets());
        exercises = loader.loadExercises();
        Set<Equipment> equipmentNeeded = loader.getEquipmentNeeded(exercises);

        MaterialToolbar topAppBar = findViewById(R.id.topAppBar);

        View reloadButton = topAppBar.findViewById(R.id.reload);
        reloadButton.setOnClickListener(v -> generateWorkout(exercises));

        View shareButton = topAppBar.findViewById(R.id.share);
        shareButton.setOnClickListener(v -> shareWorkout());

        View settingsButton = topAppBar.findViewById(R.id.settings);
        settingsButton.setOnClickListener(v -> launchSettingsActivity());

        if(exercises != null && !exercises.isEmpty()) {
            generateWorkout(exercises);
        }else{
            TextView textView = findViewById(R.id.textView2);
            String workoutAsText = res.getString(R.string.generic_error);
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
        intent.putExtra("equipment", NO_SPACE.getEquipmentNeeded().toArray());
        startActivity(intent);
    }

    private void generateWorkout(List<Exercise> exercises) {
        WorkoutCreator workoutCreator = new WorkoutCreator();
        Workout workout = workoutCreator.createWorkout(NO_SPACE, exercises);
        DefaultWorkoutPrinter printer = new DefaultWorkoutPrinter(4);
        String workoutAsText = printer.printWorkout(workout);
        TextView textView = findViewById(R.id.textView2);
        textView.setText(workoutAsText);
    }
}