package com.rk.iom.model;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Resources")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ResourceType", discriminatorType=DiscriminatorType.STRING)

public class Resource {
	@Id
	@Column(name = "res_Id")
	private int resId;
	private String title;
	private String description;
	private String category;       // Service/Product/Help
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate resDate;
	@Column(name = "res_Type")
	private String resType;          // Buy/Sell/Rent/Hire
	private double price;
	
	@ManyToOne                 
	@JoinColumn(name = "empId")         
	private Employee emp;
	
	public Resource() {
		
	}
	
	
	public Resource(int resId, String title, String description, String category, LocalDate resDate, String resType,
			double price, Employee emp) {
		super();
		this.resId = resId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.resDate = resDate;
		this.resType = resType;
		this.price = price;
		this.emp = emp;
	}



	public int getResId() {
		return resId;
	}

	public void setResId(int resId) {
		this.resId = resId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getResDate() {
		return resDate;
	}

	public void setResDate(LocalDate resDate) {
		this.resDate = resDate;
	}

	public String getResType() {
		return resType;
	}

	public void setResType(String resType) {
		this.resType = resType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Resource [resId=" + resId + ", title=" + title + ", description=" + description + ", category="
				+ category + ", resDate=" + resDate + ", resType=" + resType + ", price=" + price + ", emp=" + emp
				+ "]";
	}
	
}

