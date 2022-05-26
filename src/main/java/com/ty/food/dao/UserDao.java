package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.User;


public class UserDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public User saveUser(User user) {

		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();

		return entityManager.find(User.class, user.getId());

	}

	public User getUSerById(int id) {
		return entityManager.find(User.class, id);
	}

	public List<User> getAllUser() {

		String sql = "SELECT u FROM User u ";
		Query query = entityManager.createQuery(sql);
		List<User> users = query.getResultList();
		return users;

	}

	public User validateUser(String mail, String password) {
		String sql = "SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2 ";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, mail) ;
		query.setParameter(2, password) ;
		
		return (User)query.getSingleResult();
		
//		List<User> user = query.getResultList();
//		if (!(user.isEmpty())) {
//			return user.get(0);
//		} else
//			return null;
	}

	public boolean deleteUserById(int id) {
		User user = entityManager.find(User.class, id);
		if (user != null) {

			entityManager.remove(user);
			return true ;
		}else {
			return false ;
		}
	}
}
