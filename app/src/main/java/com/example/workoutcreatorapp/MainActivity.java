package com.example.workoutcreatorapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.content.res.Resources;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.workout.DefaultWorkoutPrinter;
import com.workout.SimpleExerciseLoader;
import com.workout.Exercise;
import com.workout.Workout;
import com.workout.WorkoutArguments;
import com.workout.WorkoutCreator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        Resources res = getResources();
        SimpleExerciseLoader loader = new SimpleExerciseLoader(res, getAssets());
        List<Exercise> exercises = loader.loadExercies();

        Button reloadBtn= findViewById(R.id.reload_button);
        reloadBtn.setOnClickListener(v -> generateWorkout(exercises));

        Button shareBtn= findViewById(R.id.share_button);
        shareBtn.setOnClickListener(v -> shareWorkout());

        String workoutAsText = res.getString(R.string.generic_error);

        if(exercises != null && !exercises.isEmpty()) {
            generateWorkout(exercises);
        }else{
            TextView textView = findViewById(R.id.textView);
            textView.setText(workoutAsText);
            reloadBtn.setEnabled(false);
            shareBtn.setEnabled(false);
        }
    }

    private void shareWorkout(){
        TextView textView = findViewById(R.id.textView);
        String workout = textView.getText().toString();

        Intent myIntent = new Intent(Intent.ACTION_SEND);
        myIntent.setType("text/plain");
        myIntent.putExtra(Intent.EXTRA_SUBJECT,"Workout");
        myIntent.putExtra(Intent.EXTRA_TEXT,workout);
        startActivity(Intent.createChooser(myIntent, "Share Using"));
    }

    private void generateWorkout(List<Exercise> exercises) {
        WorkoutCreator workoutCreator = new WorkoutCreator();
        Workout workout = workoutCreator.createWorkout(getWorkoutArguments(), exercises);
        DefaultWorkoutPrinter printer = new DefaultWorkoutPrinter(4);
        String workoutAsText = printer.printWorkout(workout);
        TextView textView = findViewById(R.id.textView);
        textView.setText(workoutAsText);
    }

    @NonNull
    private WorkoutArguments getWorkoutArguments() {
        CheckBox travelMode = findViewById(R.id.travel_mode);
        if(travelMode.isChecked()){
            return WorkoutArguments.TRAVEL_WORKOUT;
        }
        return WorkoutArguments.STANDARD_WORKOUT_2;
    }
}