package com.example.food_delivery_app.respository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food_delivery_app.entity.FoodMenu;



public interface FoodmenuRepository extends JpaRepository<FoodMenu, Long>{


}
