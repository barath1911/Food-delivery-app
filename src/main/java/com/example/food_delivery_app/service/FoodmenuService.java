package com.example.food_delivery_app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.food_delivery_app.dto.FoodMenuRequestDTO;
import com.example.food_delivery_app.entity.FoodMenu;
import com.example.food_delivery_app.entity.Restaurant;
import com.example.food_delivery_app.exception.ResourceNotFoundException;
import com.example.food_delivery_app.respository.FoodmenuRepository;
import com.example.food_delivery_app.respository.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodmenuService {


	 private final FoodmenuRepository foodmenuRepository;
	 private final RestaurantRepository restaurantRepository;
	 private final ModelMapper modelMapper;

	public FoodMenu createFoodmenu(FoodMenuRequestDTO dto) {

		 Restaurant restaurant =
		            restaurantRepository.findByName(dto.getRestaurantName())
		            .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));

		 FoodMenu foodMenu = modelMapper.map(dto, FoodMenu.class);


		 if(foodMenu.getStockQuantity()<0) {
			 throw new ResourceNotFoundException("Stock quantity cannot be negative");
		 }

		 foodMenu.setRestaurant(restaurant);

		 return foodmenuRepository.save(foodMenu);
	}


	public List<FoodMenu>getAllFoodmenu(){
		return foodmenuRepository.findAll();
	}

	public void deleteFoodmenu(Long id) {
		if (!foodmenuRepository.existsById(id)) {
            throw new ResourceNotFoundException("Food menu not found");
        }
		foodmenuRepository.deleteById(id);
	}

	public FoodMenu updateStock(Long id, int quantity) {

	    FoodMenu food = foodmenuRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Food not found"));

	    food.setStockQuantity(quantity);

	    return foodmenuRepository.save(food);
	}

}
