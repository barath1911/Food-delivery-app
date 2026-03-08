package com.example.food_delivery_app.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_delivery_app.dto.DeliveryCompleteDTO;
import com.example.food_delivery_app.dto.DeliveryRequestDTO;
import com.example.food_delivery_app.entity.Delivery;
import com.example.food_delivery_app.service.DeliveryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/delivery")
@RequiredArgsConstructor
public class DeliveryController {

	private final DeliveryService deliveryService;

	 @PostMapping("/assign")
	    public Delivery assign(@Valid @RequestBody DeliveryRequestDTO dto){

	        return deliveryService.assignDelivery(dto);
	    }

	 @PostMapping("/delivered")
	 public Delivery delivered(@Valid @RequestBody DeliveryCompleteDTO dto){

	     return deliveryService.completeDelivery(dto);
	 }
}
