package com.roanyosky.workout_tracker.dtos;

import lombok.Data;

@Data
public class CreateUserDto {
    private String email;
    private String password;
}
