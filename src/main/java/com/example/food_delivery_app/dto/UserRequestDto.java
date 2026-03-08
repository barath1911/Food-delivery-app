package com.example.food_delivery_app.dto;

import com.example.food_delivery_app.Enum.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserRequestDto {


	@NotBlank(message = "Name cannot be blank")
    private String name;

    @Email(message = "Email should be valid")

    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(
        regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$",
        message = "Password must be 8+ chars, include upper, lower, number & special character")
    private String password;

    private Role role;


}
