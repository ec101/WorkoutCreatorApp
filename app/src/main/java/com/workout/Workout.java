package com.workout;

import java.util.List;

public interface Workout {

	public List<Exercise> getExercises();

	public boolean contains(Exercise exercise);

}
