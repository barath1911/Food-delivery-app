package com.example.food_delivery_app.service;

import org.springframework.stereotype.Service;

import com.example.food_delivery_app.entity.Restaurant;
import com.example.food_delivery_app.respository.RestaurantRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantService {

	 private final RestaurantRepository restaurantRepository;

	 public Restaurant createRestaurant(Restaurant restaurant) {
		 return restaurantRepository.save(restaurant);
	 }

	 public List<Restaurant>getAllRestaurants(){
          return restaurantRepository.findAll();
	 }

	 public void deleteRestaurant(Long id) {
	        restaurantRepository.deleteById(id);
	    }
}
