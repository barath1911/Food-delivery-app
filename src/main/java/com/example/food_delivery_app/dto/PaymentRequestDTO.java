package com.example.food_delivery_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class PaymentRequestDTO {

	    @NotNull(message = "OrderId cannot be null")
	    private Long orderId;

	    @NotNull(message = "Amount cannot be null")
	    @Positive(message = "Amount must be greater than zero")
	    private Double amount;

}