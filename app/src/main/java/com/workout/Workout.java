package com.workout;

import java.util.List;

public interface Workout {

	List<Exercise> getExercises();

	boolean contains(Exercise exercise);

}
