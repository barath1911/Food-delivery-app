package com.example.food_delivery_app.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


public class LoginResponseDTO {

	 private String token;

	 public LoginResponseDTO(String token) {
	        this.token = token;
	    }

	    public String getToken() {
	        return token;
	    }
}
