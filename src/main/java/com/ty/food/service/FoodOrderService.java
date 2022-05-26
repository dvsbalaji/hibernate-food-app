package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.FoodOrderDao;
import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderService {

	public FoodOrder saveOrder(FoodOrder foodOrder) {
		int sum = 0 ;
		for(Item item : foodOrder.getItems()) {
			sum += (item.getCost() * item.getQuantity()) ;
			System.out.println(sum);
		}
		foodOrder.setTotal(sum*(1+Tax.cgst+Tax.sgst));
		FoodOrderDao dao = new FoodOrderDao();
		return dao.saveOrder(foodOrder);
	}

	public FoodOrder getOredrById(int id) {

		FoodOrderDao dao = new FoodOrderDao();
		return dao.getOredrById(id);
	}
	
	public boolean cancleOrder(int id) {
		FoodOrderDao dao = new FoodOrderDao();
		return dao.cancleOrder(id);
	}
	
	public FoodOrder UpdateFoodOredr(FoodOrder foodOrder) {
	
		FoodOrderDao dao = new FoodOrderDao();
		return dao.UpdateFoodOredr(foodOrder) ;
	}
	
	public List<FoodOrder> getFoodOrderByName(String name){
		FoodOrderDao dao = new FoodOrderDao() ;
		return dao.getFoodOrderByName(name) ;
	}
}
