package com.ken.employee.transfer.chef;

import java.util.UUID;

public class ChefListReadTO {

	private UUID chefId;

	private String name;

	private String email;

	private String department;

	private String phone;

	private String imageUrl;

	private String code;

	public UUID getChefId() {
		return chefId;
	}

	public void setChefId(UUID chefId) {
		this.chefId = chefId;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

}
