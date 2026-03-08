package com.example.food_delivery_app.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food_delivery_app.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
