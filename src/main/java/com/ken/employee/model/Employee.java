package com.ken.employee.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6965397530285110827L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(nullable = false, updatable = false)
	private UUID employeeId;

	@NotBlank
	private String name;
	@NotBlank
	private String email;
	@NotBlank
	private String jobTitle;
	
	private String phone;
	
	private String imageUrl;

	private String code;

	private UUID authId;

	@OneToMany(mappedBy = "attribuatedEmployee")
	private List<Task> tasks = new ArrayList<Task>();

	@ManyToOne
	@JoinColumn(name = "chef_Id")
	private Chef employeeChef;

	public Employee() {

	}

	public Employee(String name, String email, String jobTitle, String phone, String imageUrl) {
		this.name = name;
		this.email = email;
		this.jobTitle = jobTitle;
		this.phone = phone;
		this.imageUrl = imageUrl;
	}

	public UUID getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(UUID employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Chef getEmployeeChef() {
		return employeeChef;
	}

	public void setEmployeeChef(Chef employeeChef) {
		this.employeeChef = employeeChef;
	}

	public UUID getAuthId() {
		return authId;
	}

	public void setAuthId(UUID authId) {
		this.authId = authId;
	}

}
