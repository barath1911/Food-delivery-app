package com.example.food_delivery_app.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderRequestDTO {

	@NotBlank(message = "Customer name cannot be blank")
    @Size(min = 2, max = 50, message = "Customer name must be between 2 and 50 characters")
    private String customerName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Customer email is required")
    private String customerEmail;

    @NotBlank(message = "Delivery location is required")
    @Size(min = 3, max = 100, message = "Delivery location must be between 3 and 100 characters")
    private String deliveryLocation;

    @NotBlank(message = "Restaurant name is required")
    @Size(min = 2, max = 50, message = "Restaurant name must be between 2 and 50 characters")
    private String restaurantName;

    private List<OrderItemRequestDTO> items;
}
