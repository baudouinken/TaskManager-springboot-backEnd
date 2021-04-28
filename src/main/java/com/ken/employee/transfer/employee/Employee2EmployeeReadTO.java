package com.ken.employee.transfer.employee;

import java.util.ArrayList;

import com.ken.employee.model.Employee;
import com.ken.employee.transfer.task.Task2TaskListReadTO;

public class Employee2EmployeeReadTO {
	public static EmployeeReadTO apply(Employee in) {
		EmployeeReadTO out = new EmployeeReadTO();

		out.setEmployeeId(in.getEmployeeId());
		out.setName(in.getName());
		out.setEmail(in.getEmail());
		out.setJobTitle(in.getJobTitle());
		out.setPhone(in.getPhone());
		out.setImageUrl(in.getImageUrl());
		out.setCode(in.getCode());
		out.setEmployeeChef(in.getEmployeeChef());
		out.setAuthId(in.getAuthId());
		out.setTasks((in.getTasks() != null) ? Task2TaskListReadTO.apply(new ArrayList<>(in.getTasks())) : null);

		return out;
	}
}
