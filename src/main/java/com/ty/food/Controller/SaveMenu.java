package com.ty.food.Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.food.dto.Menu;

public class SaveMenu {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Menu  menu = new Menu() ;
		menu.setName("burger");
		menu.setCost(75);
		menu.setType("veg");
		menu.setDescription("veg loaded");
		menu.setOffer(0);
		menu.setImage("https://pixabay.com/vectors/hamburger-cheeseburger-fast-food-31775/");
		
		Menu  menu1 = new Menu() ;
		menu1.setName("burger");
		menu1.setCost(105);
		menu1.setType("non veg");
		menu1.setDescription("non-veg loaded");
		menu1.setOffer(0);
		menu1.setImage("https://pixabay.com/photos/abstract-barbecue-barbeque-bbq-1238247/");
		
		Menu  menu2 = new Menu() ;
		menu2.setName("French fries");
		menu2.setCost(45);
		menu2.setType("veg");
		menu2.setDescription("french potatoes");
		menu2.setOffer(0);
		menu2.setImage("https://cdn.pixabay.com/photo/2016/11/20/09/06/bowl-1842294__340.jpg");
		
		Menu  menu3 = new Menu() ;
		menu3.setName("pepsi");
		menu3.setCost(69);
		menu3.setType("na");
		menu3.setDescription("coca cola");
		menu3.setOffer(0);
		menu3.setImage("https://cdn.pixabay.com/photo/2019/06/17/20/13/soft-drink-4280835__340.jpg");
		
		entityTransaction.begin(); 
		entityManager.persist(menu);
		entityManager.persist(menu1);
		entityManager.persist(menu2);
		entityManager.persist(menu3);
		entityTransaction.commit();
		
	}
}
