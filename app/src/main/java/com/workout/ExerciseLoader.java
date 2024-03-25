package com.workout;

import java.util.List;
import java.util.Set;

public interface ExerciseLoader {

    List<Exercise> loadExercises();

    Set<Equipment> getEquipmentNeeded(List<Exercise> exercises);
}
