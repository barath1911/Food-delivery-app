package com.example.food_delivery_app.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food_delivery_app.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

	 Optional<Restaurant> findByName(String name);
}
