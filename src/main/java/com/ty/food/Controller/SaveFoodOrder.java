package com.ty.food.Controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class SaveFoodOrder {

	public static void main(String[] args) {

		Item item1 = new Item();
		item1.setName("french fries");
		item1.setQuantity(2);
		item1.setCost(45);	

		Item item2 = new Item();
		item2.setName("burger");
		item2.setQuantity(2);
		item2.setCost(115);

		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);

		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setItems(items);
		foodOrder.setName("bunny");
		foodOrder.setPhone(7001444676l);
		
		
		item1.setFoodOrder(foodOrder);
		item2.setFoodOrder(foodOrder);

		FoodOrderService foodOrderService = new FoodOrderService();
		if (foodOrderService.saveOrder(foodOrder) != null) {
			System.out.println("food oredred successffully");
		} else {
			System.out.println("something went wrong");
		}

	}
}
