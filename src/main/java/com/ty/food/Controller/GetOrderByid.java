package com.ty.food.Controller;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class GetOrderByid {

	public static void main(String[] args) {

		FoodOrderService foodOrderService = new FoodOrderService();
		FoodOrder foodOrder = foodOrderService.getOredrById(1);
		if (foodOrder != null) {
			for (Item item : foodOrder.getItems()) {
				System.out.println("item name  "+item.getName());
				System.out.println("item qty  "+item.getQuantity());
				System.out.println("item price  "+item.getCost());
				System.out.println("-------------------------------------------------");
			}
			
			System.out.println("customer name  : "+foodOrder.getName());
			System.out.println("customer name  : "+foodOrder.getPhone());
			System.out.println("customer name  : "+foodOrder.getTotal());
		}
	}
}
