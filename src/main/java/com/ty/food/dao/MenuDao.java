package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Menu;

public class MenuDao {

	EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("vikas") ;
	EntityManager entityManager = entityManagerFactory.createEntityManager() ;
	EntityTransaction entityTransaction = entityManager.getTransaction() ;
	
	
	public Menu saveMenu(Menu menu) {
		
		if(menu != null) {
			entityTransaction.begin();
			entityManager.persist(menu);
			entityTransaction.commit();
		}
		
		Menu uMenu = entityManager.find(Menu.class, menu.getId()) ;
		
		return uMenu;
	}
	
	public boolean updateMenu(Menu menu) {
		
		Menu menu1 = entityManager.find(Menu.class, menu.getId()) ;
		if(menu1 != null) {
			entityTransaction.begin();
			entityManager.merge(menu1) ;
			entityTransaction.commit();
			return true ;
		}
		return false ;
	}
	
	public List<Menu> getMenu() {
		
		String sql = "SELECT m FROM Menu m" ;
		Query query = entityManager.createQuery(sql) ;
		return query.getResultList() ;
	}
	
	public boolean deleteMenuById(int id) {
	
		Menu menu = entityManager.find(Menu.class, id) ;
		
		if(menu != null) {
			entityTransaction.begin();
			entityManager.remove(menu);
			entityTransaction.commit();
			return true ;
		}
		return false ;
	}
	
	public List<Menu> filterMenu(String type){
		
			String sql = "SELECT m FROM Menu m where type = ?1" ;
			Query query = entityManager.createQuery(sql) ;
			query.setParameter(1, type) ;
			
			return query.getResultList() ;	
			
		
	}
}
