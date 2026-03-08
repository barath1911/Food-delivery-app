package com.example.food_delivery_app.entity;

import com.example.food_delivery_app.Enum.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Orders{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String customerName;

    private String customerEmail;

    private String deliveryLocation;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;   // CREATED, ACCEPTED, PICKEDUP, DELIVERED

    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


}
