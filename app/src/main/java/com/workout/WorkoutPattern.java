package com.workout;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class WorkoutPattern {

    public static List<String> WORKOUT_PATTERN = Arrays.asList(new String[]{"PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS", "PUSH", "LEGS", "CARDIO", "ABS", "PULL", "LEGS", "CARDIO", "ABS"});

    private Iterator<String> patternIterator;
    private final List<String> workoutPattern;

    public WorkoutPattern(){
        workoutPattern = WORKOUT_PATTERN;
        patternIterator = workoutPattern.iterator();
    }

    public WorkoutPattern(List<String> pattern){
        workoutPattern = pattern;
        patternIterator = pattern.iterator();
    }

    public String getNextWorkoutType(){
        if(!patternIterator.hasNext()){
            patternIterator = workoutPattern.iterator();
        }
        return patternIterator.next();
    }
}
