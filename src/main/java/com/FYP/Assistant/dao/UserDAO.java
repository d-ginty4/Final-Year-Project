package com.FYP.Assistant.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FYP.Assistant.entity.User;

@Repository
public class UserDAO {

	private EntityManager entityManager;
	
	@Autowired
	public UserDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Transactional
	public User findById(int userId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		User theUser = currentSession.get(User.class, userId);
		
		return theUser;
	}

	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<User> theQuery = currentSession.createQuery("delete from User where id=:userId");
		
		theQuery.setParameter("userId", id);
		
		theQuery.executeUpdate();
	}

	@Transactional
	public void save(User theUser) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theUser);
	}

	@Transactional
	public User findByDetails(String name, String password) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String hql = "FROM User U WHERE U.username = '" + name + "'";
		Query query = currentSession.createQuery(hql);
		
		return (User) query.list().get(0);
	}
}
