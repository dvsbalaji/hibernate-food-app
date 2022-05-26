package com.ty.food.Controller;

import java.util.List;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class FilterMenuByType {

	public static void main(String[] args) {
		MenuService menuService = new MenuService() ;
		List<Menu> menu = menuService.filterMenu("veg") ;
		
		if(! (menu.isEmpty()) ) {
			for(Menu  menu2 : menu) {
				System.out.println(menu2.getName());
				System.out.println(menu2.getType());
				System.out.println(menu2.getDescription());
				System.out.println(menu2.getCost());
			
				System.out.println("-----------------------------");
			}
		}else {
			System.out.println("no food with specified type");
		}
	}
}
