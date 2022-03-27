package com.FYP.Assistant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quick_note")
public class QuickNote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="note")
	private String note;
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="user_id")
	private int userId;
	
	@Column(name="project_id")
	private int projectId;
	
	public QuickNote() {
		
	}

	public QuickNote(String title, String note, boolean status, int projectId, int userId) {
		this.title = title;
		this.note = note;
		this.status = status;
		this.projectId = projectId;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "QuickNote [id=" + id + ", note=" + note + ", status=" + status + ", projectId=" + projectId + "]";
	}
}
