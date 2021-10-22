package com.example.workoutcreatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.preference.PreferenceFragmentCompat;

import com.workout.DefaultWorkoutPrinter;
import com.workout.SimpleExcerciseLoader;
import com.workout.Exercise;
import com.workout.Workout;
import com.workout.WorkoutArguments;
import com.workout.WorkoutCreator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final int REQUEST_CODE_SIGN_IN = 1;
    private static final int REQUEST_CODE_OPEN_DOCUMENT = 2;

    //private DriveServiceHelper mDriveServiceHelper;
    private String mOpenFileId;

    private EditText mFileTitleEditText;
    private EditText mDocContentEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        Resources res = getResources();
        SimpleExcerciseLoader loader = new SimpleExcerciseLoader(res, getAssets());
        List<Exercise> exercises = loader.loadExercies();

        Button reloadBtn= findViewById(R.id.reload_button);
        reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                generateWorkout(exercises);
            }
        });

        Button shareBtn= findViewById(R.id.share_button);
        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                shareWorkout();
            }
        });

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

    private void generateWorkout(List<Exercise> exercises){
        WorkoutCreator workoutCreator = new WorkoutCreator();
        Workout workout = workoutCreator.createWorkout(WorkoutArguments.STANDARD_WORKOUT_2, exercises);
        DefaultWorkoutPrinter printer = new DefaultWorkoutPrinter(4);
        String workoutAsText = printer.printWorkout(workout);
        TextView textView = findViewById(R.id.textView);
        textView.setText(workoutAsText);
    }

//    public static class SettingsFragment extends PreferenceFragmentCompat {
//        @Override
//        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
//            setPreferencesFromResource(R.xml.root_preferences, rootKey);
//        }
//    }
}