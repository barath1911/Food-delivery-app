package com.example.food_delivery_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DeliveryRequestDTO {

	@NotNull(message = "OrderId cannot be null")
	 private Long orderId;


	@NotBlank(message = "DeliveryPartner name cannot be blank")
    @Size(min = 2, max = 50, message = "Customer name must be between 2 and 50 characters")
	 private String deliveryPartnerName;
}
