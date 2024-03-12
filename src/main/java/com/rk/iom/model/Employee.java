package com.rk.iom.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Employees")
public class Employee {

	@Id
	@Column(name = "emp_id")
	private int empId;

	@NotBlank(message = "name cannot be blank")
	@Column(name = "emp_name")
	private String empName;

	@NotBlank(message = "department name cannot be blank")
	@Column(name = "dept_name")
	private String deptName;

	@NotBlank
	@Column(name = "emp_loc")
	private String location;

	@JsonIgnore
	@OneToOne(mappedBy = "employee")
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "emp", cascade = CascadeType.ALL)
	private Set<Proposal> proposals = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy = "emp", cascade = CascadeType.ALL)
//	@OneToMany(mappedBy = "emp")
	private Set<Resource> resources = new HashSet<>();

	public Employee() {

	}

	public Employee(int empId, String empName, String deptName, String location, User user) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.deptName = deptName;
		this.location = location;
		this.user = user;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Proposal> getProposals() {
		return proposals;
	}

	public void setProposals(Set<Proposal> proposals) {
		this.proposals = proposals;
	}

	public Set<Resource> getResources() {
		return resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", deptName=" + deptName + ", location=" + location
				+ " proposals=" + proposals + ", resources=" + resources + "]";
	}

}
