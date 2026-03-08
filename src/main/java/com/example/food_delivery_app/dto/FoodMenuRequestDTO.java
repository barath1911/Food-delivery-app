package com.example.food_delivery_app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FoodMenuRequestDTO {

	@NotBlank(message = "Name cannot be blank")
	private String foodname;

	@Positive(message = "Price must be greater than 0")
    private double price;

	 @Size(max = 200, message = "Description max 200 characters")
    private String description;

	 @Min(value = 0, message = "Stock quantity cannot be negative")
	 private int stockQuantity;

	 @NotBlank(message = "Restaurant name is required")
    private String restaurantName;
}
