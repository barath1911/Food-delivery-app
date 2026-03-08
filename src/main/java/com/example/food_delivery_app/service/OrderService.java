package com.example.food_delivery_app.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.food_delivery_app.Enum.OrderStatus;
import com.example.food_delivery_app.dto.OrderItemRequestDTO;
import com.example.food_delivery_app.dto.OrderRequestDTO;
import com.example.food_delivery_app.entity.FoodMenu;
import com.example.food_delivery_app.entity.OrderItems;
import com.example.food_delivery_app.entity.Orders;
import com.example.food_delivery_app.entity.Restaurant;
import com.example.food_delivery_app.exception.ResourceNotFoundException;
import com.example.food_delivery_app.respository.FoodmenuRepository;
import com.example.food_delivery_app.respository.OrderItemsRepository;
import com.example.food_delivery_app.respository.OrderRepository;
import com.example.food_delivery_app.respository.RestaurantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

	    private final OrderRepository orderRepository;
	    private final OrderItemsRepository orderItemsRepository;
	    private final RestaurantRepository restaurantRepository;
	    private final FoodmenuRepository foodmenuRepository;
	    private final ModelMapper modelMapper;

	    public Orders createOrders(OrderRequestDTO dto){
	    	Restaurant restaurant=restaurantRepository.findByName(dto.getRestaurantName())
	    			.orElseThrow(()-> new ResourceNotFoundException("Restaurant Not Found"));

	    	Orders order=modelMapper.map(dto, Orders.class);

	    	order.setRestaurant(restaurant);
	    	order.setStatus(OrderStatus.CREATED);

	    	Orders saveOrder=orderRepository.save(order);

	    	double totalPrice = 0;

	    	for(OrderItemRequestDTO itemDTO: dto.getItems()){

	    		FoodMenu food=foodmenuRepository.findById(itemDTO.getFoodMenuId())
	    				.orElseThrow(()-> new ResourceNotFoundException("Food not found"));

	    		if(food.getStockQuantity()<itemDTO.getQuantity()){
	    			 throw new ResourceNotFoundException("Food out of stock");
	    		}

	    		food.setStockQuantity(food.getStockQuantity()-itemDTO.getQuantity());
	    		foodmenuRepository.save(food);

	    		OrderItems item = new OrderItems();

	            item.setFoodName(food.getFoodname());
	            item.setPrice(food.getPrice());
	            item.setQuantity(itemDTO.getQuantity());

	    		double itemtotal=itemDTO.getQuantity()*food.getPrice();
	    		item.setTotalPrice(itemtotal);

	    		item.setOrder(saveOrder);

	    		orderItemsRepository.save(item);

	    		totalPrice += itemtotal;
	    		}
	    	saveOrder.setTotalPrice(totalPrice);

	    	return orderRepository.save(saveOrder);
	    	}
	    }

