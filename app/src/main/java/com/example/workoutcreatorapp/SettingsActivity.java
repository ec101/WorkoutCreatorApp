package com.example.workoutcreatorapp;

import android.os.Bundle;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.workout.Equipment;
import com.workout.WorkoutArguments;

import java.util.Set;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);

        Set<Equipment> equipmentNeeded = WorkoutArguments.getInstance().getEquipmentNeeded();

        CheckBox resistanceBandCheckBox = findViewById(R.id.withResistanceBand);
        resistanceBandCheckBox.setChecked(equipmentNeeded.contains(Equipment.RESISTANCE_BAND));
        resistanceBandCheckBox.setOnCheckedChangeListener((compoundButton, b) -> updateResistanceBandSetting(b));

        CheckBox kettleBellCheckBox = findViewById(R.id.withKettle);
        kettleBellCheckBox.setChecked(equipmentNeeded.contains(Equipment.KETTLE_BELL));
        kettleBellCheckBox.setOnCheckedChangeListener((compoundButton, b) -> updateKettleBellSetting(b));

        CheckBox spaceRestrictionsCheckBox = findViewById(R.id.spaceRestrictions);
        spaceRestrictionsCheckBox.setChecked(equipmentNeeded.contains(Equipment.SPACE));
        spaceRestrictionsCheckBox.setOnCheckedChangeListener((compoundButton, b) -> updateSpaceRestrictionSetting(b));

        CheckBox chairCheckBox = findViewById(R.id.withChair);
        chairCheckBox.setChecked(equipmentNeeded.contains(Equipment.CHAIR));
        chairCheckBox.setOnCheckedChangeListener((compoundButton, b) -> updateChairSetting(b));
    }

    private void updateResistanceBandSetting(boolean value){
        updateEquipmentNeeded(value, Equipment.RESISTANCE_BAND);
    }

    private void updateKettleBellSetting(boolean value){
        updateEquipmentNeeded(value, Equipment.KETTLE_BELL);
    }

    private void updateSpaceRestrictionSetting(boolean value){
        updateEquipmentNeeded(value, Equipment.SPACE);
    }

    private void updateChairSetting(boolean value){
        updateEquipmentNeeded(value, Equipment.CHAIR);
    }

    private void updateEquipmentNeeded(boolean value, Equipment equipment) {
        Set<Equipment> equipmentNeeded = WorkoutArguments.getInstance().getEquipmentNeeded();
        if(value){
            equipmentNeeded.add(equipment);
        }else{
            equipmentNeeded.remove(equipment);
        }
    }

}
