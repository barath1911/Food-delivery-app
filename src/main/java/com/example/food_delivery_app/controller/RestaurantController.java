package com.example.food_delivery_app.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.food_delivery_app.entity.Restaurant;
import com.example.food_delivery_app.service.RestaurantService;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController{

	private final RestaurantService restaurantService;

	 @GetMapping
	    public List<Restaurant> getAll() {
	        return restaurantService.getAllRestaurants();
	    }

	 @PostMapping
	    public Restaurant create(@RequestBody Restaurant restaurant) {
	        return restaurantService.createRestaurant(restaurant);
	    }

	 @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	        restaurantService.deleteRestaurant(id);
	    }

}
