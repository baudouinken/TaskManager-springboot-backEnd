package com.ken.employee.transfer.employee;

import java.util.UUID;

import com.ken.employee.model.Chef;

public class EmployeeListReadTO {

	protected UUID employeeId;

	protected String name;

	protected String email;

	protected String jobTitle;

	protected String phone;

	protected String imageUrl;

	protected String code;

	protected Chef employeeChef;

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

	public Chef getEmployeeChef() {
		return employeeChef;
	}

	public void setEmployeeChef(Chef employeeChef) {
		this.employeeChef = employeeChef;
	}

}
