package com.example.food_delivery_app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_delivery_app.dto.PaymentRequestDTO;
import com.example.food_delivery_app.entity.Payment;
import com.example.food_delivery_app.service.PaymentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {

	 private final PaymentService paymentService;

	 @PostMapping("/pay")
	 public Payment processPayment(@Valid @RequestBody PaymentRequestDTO dto) {
	        return paymentService.processPayment(dto);
	    }
}
