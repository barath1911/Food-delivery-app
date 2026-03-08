package com.example.food_delivery_app.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food_delivery_app.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
