package com.example.food_delivery_app.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class OrderItemRequestDTO {

	    @Min(value = 1, message = "FoodMenuId must be valid")
	    private Long foodMenuId;

	    @Min(value = 1, message = "Quantity must be at least 1")
	    private int quantity;
}
