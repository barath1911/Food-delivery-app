package com.example.food_delivery_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DeliveryCompleteDTO {

	@NotNull(message = "Delivery ID cannot be null")
	 private Long deliveryId;

	 @NotNull(message = "Customer ID cannot be null")
	    private Long customerId;

	 @NotBlank(message = "Customer name cannot be blank")
	    private String customerName;
}
