package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.MenuDao;
import com.ty.food.dto.Menu;

public class MenuService {

	MenuDao dao = new MenuDao() ;
	
	public Menu saveMenu(Menu menu) {
		return dao.saveMenu(menu) ;
	}
	
	public boolean updateMenu(Menu menu) {
		return dao.updateMenu(menu) ;
	}
	
	public List<Menu> getMenu(){
		return dao.getMenu() ;
	}
	
	public boolean deleteMenuById(int id) {
		return dao.deleteMenuById(id) ;
	}
	
	public List<Menu> filterMenu(String type){
		return dao.filterMenu(type) ;
	}
}
