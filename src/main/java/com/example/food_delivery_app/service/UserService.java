package com.example.food_delivery_app.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.food_delivery_app.Enum.Role;
import com.example.food_delivery_app.dto.LoginRequestDTO;
import com.example.food_delivery_app.dto.LoginResponseDTO;
import com.example.food_delivery_app.dto.UserRequestDto;
import com.example.food_delivery_app.dto.UserResponseDTO;
import com.example.food_delivery_app.entity.User;
import com.example.food_delivery_app.exception.ResourceNotFoundException;
import com.example.food_delivery_app.respository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;


	public UserResponseDTO saveuser(UserRequestDto dto) {

		if(userRepository.existsByEmail(dto.getEmail())) {
			 throw new ResourceNotFoundException("Email already exists");
		}

		// DTO → Entity

		User user=modelMapper.map(dto, User.class);

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		user.setRole(dto.getRole());

		User savedUser=userRepository.save(user);

        // Entity → ResponseDTO
		return modelMapper.map(savedUser, UserResponseDTO.class);
	}

	public LoginResponseDTO login(LoginRequestDTO request) {

	    User user = userRepository.findByEmail(request.getEmail())
	            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

	    if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
	        throw new ResourceNotFoundException("Invalid password");
	    }

	    String token = jwtService.generateToken(user.getEmail(),user.getRole().name());

	    return new LoginResponseDTO(token);
	}
}
