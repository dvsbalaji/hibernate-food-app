package com.ty.food.Controller;


import com.ty.food.service.FoodOrderService;

public class CancleFoodOrder {

	public class SaveMenu {

	}

	public static void main(String[] args) {

		FoodOrderService foodOrderService = new FoodOrderService();
		boolean res = foodOrderService.cancleOrder(1) ;
		
		if(res == true) {
			System.out.println("order cancelled successfully");
		}else {
			System.out.println("no oredre found to cancel");
		}
		
	}
}
