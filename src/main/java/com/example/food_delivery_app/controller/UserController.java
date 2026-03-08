package com.example.food_delivery_app.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_delivery_app.dto.LoginRequestDTO;
import com.example.food_delivery_app.dto.LoginResponseDTO;
import com.example.food_delivery_app.dto.UserRequestDto;
import com.example.food_delivery_app.dto.UserResponseDTO;
import com.example.food_delivery_app.entity.User;
import com.example.food_delivery_app.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController{

	 private final UserService userService;

	 @PostMapping("/register")
	 public UserResponseDTO registerUser(
	         @Valid @RequestBody UserRequestDto requestDTO){

	     return userService.saveuser(requestDTO);
	 }

	 @PostMapping("/login")
	 public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO request) {
	     return userService.login(request);
	 }
}
