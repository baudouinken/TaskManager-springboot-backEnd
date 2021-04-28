package com.ken.employee.transfer.chef;

import java.util.ArrayList;

import com.ken.employee.model.Chef;
import com.ken.employee.transfer.employee.Employee2EmployeeListReadTO;
import com.ken.employee.transfer.task.Task2TaskListReadTO;

public class Chef2ChefReadTO {

	public static ChefReadTO apply(Chef in) {

		ChefReadTO out = new ChefReadTO();
		out.setChefId(in.getChefId());
		out.setName(in.getName());
		out.setEmail(in.getEmail());
		out.setDepartment(in.getDepartment());
		out.setPhone(in.getPhone());
		out.setImageUrl(in.getImageUrl());
		out.setCode(in.getCode());
		out.setAuthId(in.getAuthId());
		out.setTasks((in.getTasks() != null) ? Task2TaskListReadTO.apply(new ArrayList<>(in.getTasks())) : null);
		out.setEmployees(
				(in.getEmployees() != null) ? Employee2EmployeeListReadTO.apply(new ArrayList<>(in.getEmployees()))
						: null);

		return out;
	}

}
