package com.FYP.Assistant.dao;

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
}