package com.example.food_delivery_app.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_delivery_app.dto.OrderRequestDTO;
import com.example.food_delivery_app.entity.Orders;
import com.example.food_delivery_app.service.OrderService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	public Orders createOrder(@Valid @RequestBody OrderRequestDTO dto) {
		return orderService.createOrders(dto);
	}

}
