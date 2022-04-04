package com.FYP.Assistant.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.FYP.Assistant.entity.QuickNote;
import com.FYP.Assistant.entity.User;

@Repository
public class QuickNoteDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public QuickNoteDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Transactional
	public QuickNote findById(int noteId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		QuickNote note = currentSession.get(QuickNote.class, noteId);
		
		return note;
	}
	
	@Transactional
	public void deletedById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<QuickNote> theQuery = currentSession.createQuery("delete from QuickNote where id=:noteId");
		
		theQuery.setParameter("noteId", id);
		
		theQuery.executeUpdate();
	}
	
	@Transactional
	public void save(QuickNote theQuickNote) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theQuickNote);
	}

	@Transactional
	public List<QuickNote> findAll(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String hql = "FROM QuickNote Q WHERE Q.userId = " + id + "AND Q.projectId = 0";
		Query<QuickNote> query = currentSession.createQuery(hql);
		
		return query.list();
	}

	@Transactional
	public List<QuickNote> projectNotes(int projectId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		String hql = "FROM QuickNote Q WHERE Q.projectId = " + projectId;
		Query<QuickNote> query = currentSession.createQuery(hql);
		
		return query.list();
	}
}
