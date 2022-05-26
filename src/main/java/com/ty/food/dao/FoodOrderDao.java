package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public FoodOrder saveOrder(FoodOrder foodOrder) {

		entityTransaction.begin();
		
		entityManager.persist(foodOrder);

		entityTransaction.commit();

		FoodOrder order = entityManager.find(FoodOrder.class, foodOrder.getId());

		return order;

	}
	
	public FoodOrder UpdateFoodOredr(FoodOrder foodOrder) {
		entityTransaction.begin();
		for (Item item : foodOrder.getItems()) {
			entityManager.merge(item);
		}
		entityManager.merge(foodOrder);

		entityTransaction.commit();

		FoodOrder order = entityManager.find(FoodOrder.class, foodOrder.getId());

		return order;
	}

	public FoodOrder getOredrById(int id) {

		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		return foodOrder;
	}

	public boolean cancleOrder(int id) {
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		if (foodOrder != null) {
			entityTransaction.begin();

			for (Item item : foodOrder.getItems()) {
				entityManager.remove(item);
			}
			entityManager.remove(foodOrder);
			entityTransaction.commit();
			return true;

		}
		return false;
	}
	
	public List<FoodOrder> getFoodOrderByName(String name){
		
		String sql = "SELECT fo FROM FoodOrder fo where name = ?1" ;
		Query query = entityManager.createQuery(sql) ;
		query.setParameter(1, name) ;
		
		return query.getResultList() ;	
		
	}
}
