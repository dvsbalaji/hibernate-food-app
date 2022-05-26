package com.ty.food.Controller;

import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class GetFoodOrderByName {

	public static void main(String[] args) {
		FoodOrderService foodOrderService = new FoodOrderService() ;
		List<FoodOrder> foodOrders = foodOrderService.getFoodOrderByName("bunny") ;
		
		if(!(foodOrders.isEmpty())) {
			for(FoodOrder foodOrder : foodOrders) {
				System.out.println(foodOrder.getName());
				System.out.println(foodOrder.getPhone());
				
				System.out.println("--------------------------------------");
				
				for(Item item : foodOrder.getItems()) {
					
					System.out.println(item.getName());
					System.out.println(item.getQuantity());
					System.out.println(item.getCost());
				}
				
				System.out.println("--------------------------------------");
				
				System.out.println("total    " + foodOrder.getTotal());
			}
		}
		
	}
}
