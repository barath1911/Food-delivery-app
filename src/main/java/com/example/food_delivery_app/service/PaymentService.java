package com.example.food_delivery_app.service;

import java.time.LocalDateTime;

import org.hibernate.query.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.food_delivery_app.Enum.OrderStatus;
import com.example.food_delivery_app.Enum.PaymentStatus;
import com.example.food_delivery_app.dto.PaymentRequestDTO;
import com.example.food_delivery_app.entity.Orders;
import com.example.food_delivery_app.entity.Payment;
import com.example.food_delivery_app.exception.ResourceNotFoundException;
import com.example.food_delivery_app.respository.OrderRepository;
import com.example.food_delivery_app.respository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService{

	private final PaymentRepository paymentRepository;
	private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

	public Payment processPayment(PaymentRequestDTO dto) {

		 Orders order = orderRepository.findById(dto.getOrderId())
	                .orElseThrow(() -> new ResourceNotFoundException("Order not found"));

		 Payment payment = new Payment();
	        payment.setOrderId(dto.getOrderId());
	        payment.setAmount(dto.getAmount());
        payment.setPaymentTime(LocalDateTime.now());

        if(dto.getAmount().equals(order.getTotalPrice())) {
        	payment.setStatus(PaymentStatus.SUCCESS);
        	 order.setStatus(OrderStatus.ACCEPTED);
        	 orderRepository.save(order);
        }else {
        	 payment.setStatus(PaymentStatus.FAILED);

        }

        return paymentRepository.save(payment);
	}
}
