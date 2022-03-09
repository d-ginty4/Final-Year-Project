package com.FYP.Assistant.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FYP.Assistant.entity.Job;
import com.FYP.Assistant.entity.User;

@Repository
public class JobDAO {

	private EntityManager entityManager;
	
	@Autowired
	public JobDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Transactional
	public Job findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Job theJob = currentSession.get(Job.class, id);
		
		return theJob;
	}
	
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Job> theQuery = currentSession.createQuery("delete from Job where id=:jobId");
		
		theQuery.setParameter("jobId", id);
		
		theQuery.executeUpdate();
	}
	
	@Transactional
	public void save(Job theJob) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theJob);
	}
}
