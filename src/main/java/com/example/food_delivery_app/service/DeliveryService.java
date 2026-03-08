package com.example.food_delivery_app.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.food_delivery_app.Enum.OrderStatus;
import com.example.food_delivery_app.dto.DeliveryCompleteDTO;
import com.example.food_delivery_app.dto.DeliveryRequestDTO;
import com.example.food_delivery_app.entity.Delivery;
import com.example.food_delivery_app.entity.Orders;
import com.example.food_delivery_app.exception.ResourceNotFoundException;
import com.example.food_delivery_app.respository.DeliveryRepository;
import com.example.food_delivery_app.respository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliveryService {

	private final DeliveryRepository deliveryRepository;
	private final OrderRepository orderRepository;
	private final ModelMapper modelMapper;

	public Delivery assignDelivery(DeliveryRequestDTO dto){
			Orders order=orderRepository.findById(dto.getOrderId())
					.orElseThrow(()-> new ResourceNotFoundException("Order Not found"));
			order.setStatus(OrderStatus.PICKEDUP);

			Delivery delivery = new Delivery();

			delivery.setOrderId(dto.getOrderId());
			delivery.setDeliveryPartnerName(dto.getDeliveryPartnerName());

			 delivery.setAssignedTime(LocalDateTime.now());
		        delivery.setStatus(OrderStatus.PICKEDUP);

		        return deliveryRepository.save(delivery);

	}

	public Delivery completeDelivery(DeliveryCompleteDTO dto) {

	    Delivery delivery = deliveryRepository.findById(dto.getDeliveryId())
	            .orElseThrow(() -> new ResourceNotFoundException("Delivery not found"));

	    Orders order = orderRepository.findById(delivery.getOrderId())
	            .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

	    if(order.getStatus() == OrderStatus.DELIVERED){
	        throw new ResourceNotFoundException("Order already delivered");
	    }

	    // check correct customer
	    if(!order.getId().equals(dto.getCustomerId()) ||
	       !order.getCustomerName().equalsIgnoreCase(dto.getCustomerName())){

	        throw new ResourceNotFoundException("Wrong customer. Delivery cannot be completed");
	    }

	    delivery.setStatus(OrderStatus.DELIVERED);

	    order.setStatus(OrderStatus.DELIVERED);

	    orderRepository.save(order);

	    return deliveryRepository.save(delivery);
	}
}
