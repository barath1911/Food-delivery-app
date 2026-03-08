package com.example.food_delivery_app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.food_delivery_app.dto.FoodMenuRequestDTO;
import com.example.food_delivery_app.entity.FoodMenu;
import com.example.food_delivery_app.service.FoodmenuService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/foodmenu")
@RequiredArgsConstructor
public class FoodmenuController{

	private final FoodmenuService foodmenuService;

	@GetMapping
	public List<FoodMenu>getAll(){
		return foodmenuService.getAllFoodmenu();
	}

	@PostMapping
    public FoodMenu create(@Valid @RequestBody FoodMenuRequestDTO dto){
        return foodmenuService.createFoodmenu(dto);
    }

	@DeleteMapping("/delete/{id}")
    public String deleteFoodmenu(@PathVariable Long id) {
        foodmenuService.deleteFoodmenu(id);
        return "Food menu deleted successfully";
    }

	 @PutMapping("/updateStock/{id}")
	    public FoodMenu updateStock(@PathVariable Long id,
	                                @RequestParam int quantity) {

	        return foodmenuService.updateStock(id, quantity);
	    }
}
