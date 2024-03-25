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
        String[] equipment = intent.getStringArrayExtra("equipment");

//        CheckBox resistanceBandCheckBox = findViewById(R.id.withResistanceBand);
//        resistanceBandCheckBox.setChecked(MainActivity.NO_SPACE.isResistanceBand());
//        resistanceBandCheckBox.setOnCheckedChangeListener((compoundButton, b) -> updateResistanceBandSetting(b));
//
//        CheckBox kettleBellCheckBox = findViewById(R.id.withKettle);
//        kettleBellCheckBox.setChecked(MainActivity.NO_SPACE.isKettleBell());
//        kettleBellCheckBox.setOnCheckedChangeListener((compoundButton, b) -> updateKettleBellSetting(b));
//
//        CheckBox spaceRestrictionsCheckBox = findViewById(R.id.spaceRestrictions);
//        spaceRestrictionsCheckBox.setChecked(MainActivity.NO_SPACE.isSpaceRestrictions());
//        spaceRestrictionsCheckBox.setOnCheckedChangeListener((compoundButton, b) -> updateSpaceRestrictionSetting(b));
//
//        CheckBox chairCheckBox = findViewById(R.id.withChair);
//        chairCheckBox.setChecked(MainActivity.NO_SPACE.isSpaceRestrictions());
//        chairCheckBox.setOnCheckedChangeListener((compoundButton, b) -> updateChairSetting(b));
    }

//    private void updateResistanceBandSetting(boolean value){
//        MainActivity.NO_SPACE.setResistanceBand(value);
//    }
//
//    private void updateKettleBellSetting(boolean value){
//        MainActivity.NO_SPACE.setKettleBell(value);
//    }
//
//    private void updateSpaceRestrictionSetting(boolean value){
//        MainActivity.NO_SPACE.setSpaceRestrictions(value);
//    }
//
//    private void updateChairSetting(boolean value){
//        MainActivity.NO_SPACE.setSpaceRestrictions(value);
//    }
}
