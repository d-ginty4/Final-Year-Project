package com.FYP.Assistant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FYP.Assistant.entity.Project;
import com.FYP.Assistant.entity.QuickNote;
import com.FYP.Assistant.entity.User;

@Repository
public class ProjectDAO {

	private EntityManager entityManager;
	
	@Autowired
	public ProjectDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Transactional
	public Project findById(int projectId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Project theProject = currentSession.get(Project.class, projectId);
		
		return theProject;
	}
	
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Project> theQuery = currentSession.createQuery("delete from Project where id=:projectId");
		
		theQuery.setParameter("projectId", id);
		
		theQuery.executeUpdate();
	}
	
	@Transactional
	public void save(Project theProject) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theProject);
	}

	@Transactional
	public List<Project> findUserProjects(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String hql = "FROM Project P WHERE P.userId = " + id;
		Query<Project> query = currentSession.createQuery(hql);
		
		return query.list();
	}
}
