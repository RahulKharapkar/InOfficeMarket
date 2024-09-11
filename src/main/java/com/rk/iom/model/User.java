package com.rk.iom.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@Column(name = "user_id")
	private int	 userId;
	private String password;
	@Column(name = "email_id")
	private String emailId;

	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="emp_id")
	private Employee employee;
	
	public User() { 					

	}
	
	
	public User(int userId, String password, String emailId, Employee employee) {
		super();
		this.userId = userId;
		this.password = password;
		this.emailId = emailId;
		this.employee = employee;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", emailId=" + emailId + ", employee=" + employee
				+ "]";
	}

	
}
