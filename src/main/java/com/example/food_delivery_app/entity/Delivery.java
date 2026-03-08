package com.example.food_delivery_app.entity;

import java.time.LocalDateTime;

import com.example.food_delivery_app.Enum.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
public class Delivery {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private Orders order;

    private String deliveryPartnerName;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private LocalDateTime assignedTime;
}
