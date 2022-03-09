package com.FYP.Assistant.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "project_id")
	private int projectId;
	
	@Column(name = "due_date")
	private LocalDate dueDate;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "status")
	private boolean status;
	
	public Job() {
		
	}

	public Job(int userId, int projectId, LocalDate dueDate, String note, String title, boolean status) {
		this.userId = userId;
		this.projectId = projectId;
		this.dueDate = dueDate;
		this.note = note;
		this.title = title;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Job [id=" + id + ", userId=" + userId + ", projectId=" + projectId + ", dueDate=" + dueDate + ", note="
				+ note + ", title=" + title + ", status=" + status + "]";
	}
}
