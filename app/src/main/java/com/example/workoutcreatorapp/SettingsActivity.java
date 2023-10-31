package com.example.workoutcreatorapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;

import com.workout.WorkoutArguments;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        Resources resources = getResources();
        Intent intent = getIntent();

        CheckBox resistanceBandCheckBox = findViewById(R.id.withResistanceBand);
        resistanceBandCheckBox.setChecked(WorkoutArguments.WORKOUT_ARGS.isResistanceBand());
        resistanceBandCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                updateResistanceBandSetting(b);
            }
        });

        CheckBox kettleBellCheckBox = findViewById(R.id.withKettle);
        kettleBellCheckBox.setChecked(WorkoutArguments.WORKOUT_ARGS.isKettleBell());
        kettleBellCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                updateKettleBellSetting(b);
            }
        });

        CheckBox spaceRestrictionsCheckBox = findViewById(R.id.spaceRestrictions);
        spaceRestrictionsCheckBox.setChecked(WorkoutArguments.WORKOUT_ARGS.isSpaceRestrictions());
        spaceRestrictionsCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                updateSpaceRestrictionSetting(b);
            }
        });
    }

    private void updateResistanceBandSetting(boolean value){
        WorkoutArguments.WORKOUT_ARGS.setResistanceBand(value);
    }

    private void updateKettleBellSetting(boolean value){
        WorkoutArguments.WORKOUT_ARGS.setKettleBell(value);
    }

    private void updateSpaceRestrictionSetting(boolean value){
        WorkoutArguments.WORKOUT_ARGS.setSpaceRestrictions(value);
    }

}
