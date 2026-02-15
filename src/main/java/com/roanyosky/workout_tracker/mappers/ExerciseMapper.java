package com.roanyosky.workout_tracker.mappers;

import com.roanyosky.workout_tracker.dtos.CreateExerciseDto;
import com.roanyosky.workout_tracker.dtos.UpdateExerciseDto;
import com.roanyosky.workout_tracker.entities.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ExerciseMapper {
    CreateExerciseDto toDto(Exercise exercise);

    Exercise toEntity(CreateExerciseDto createExerciseDto);

    void updateDto(UpdateExerciseDto updateExerciseDto, @MappingTarget Exercise exercise);
}
