package com.ty.food.Controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class UpdateFoodOrder {

	public static void main(String[] args) {

		Item item1 = new Item();
		item1.setId(3);
		item1.setName("french fries");
		item1.setQuantity(2);
		item1.setCost(380);	

		Item item2 = new Item();
		item2.setId(4);
		item2.setName("burger");
		item2.setQuantity(1);
		item2.setCost(125);

		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);

		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setItems(items);
		foodOrder.setId(2);
		foodOrder.setName("bunny");
		foodOrder.setPhone(7001444676l);
		foodOrder.setTotal(item1.getCost() + item2.getCost());
		
		item1.setFoodOrder(foodOrder);
		item2.setFoodOrder(foodOrder);

		FoodOrderService foodOrderService = new FoodOrderService();
		if (foodOrderService.UpdateFoodOredr(foodOrder) != null) {
			System.out.println("foode oredr updated successffully");
		} else {
			System.out.println("something went wrong");
		}

	}
}
