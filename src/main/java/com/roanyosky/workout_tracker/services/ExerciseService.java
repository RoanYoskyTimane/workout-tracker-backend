package com.roanyosky.workout_tracker.services;

import com.roanyosky.workout_tracker.dtos.CreateExerciseDto;
import com.roanyosky.workout_tracker.dtos.ExerciseDto;
import com.roanyosky.workout_tracker.dtos.UpdateExerciseDto;
import com.roanyosky.workout_tracker.entities.Exercise;
import com.roanyosky.workout_tracker.mappers.ExerciseMapper;
import com.roanyosky.workout_tracker.repositories.ExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;
    private final ExerciseMapper exerciseMapper;

    public ExerciseDto createExercise(CreateExerciseDto createExerciseDto){
        Exercise exercise = exerciseMapper.toEntity(createExerciseDto);
        System.out.println("Name: "+createExerciseDto.getName());
        System.out.println("Category: "+createExerciseDto.getCategory());
        System.out.println("Muscle type: "+createExerciseDto.getMuscleGroup());
        System.out.println("Name from entity: "+exercise.getName());
        System.out.println("Category from entity: "+exercise.getCategory());
        System.out.println("Muscle type from entity: "+exercise.getMuscleGroup());
        exerciseRepository.save(exercise);

        return exerciseMapper.toDto(exercise);
    }

    public ExerciseDto updateExercise(String name,UpdateExerciseDto updateExerciseDto){
        Exercise exercise = exerciseRepository.findByName(name);

        exerciseMapper.updateDto(updateExerciseDto, exercise);

        return exerciseMapper.toDto(exercise);
    }

    public void deleteExercise(String name){
        Exercise exercise = exerciseRepository.findByName(name);
        exerciseRepository.delete(exercise);
    }
}
