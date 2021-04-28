package com.ken.employee.transfer.employee;

import java.util.List;
import java.util.stream.Collectors;

import com.ken.employee.model.Employee;

public class Employee2EmployeeListReadTO {

	public static EmployeeListReadTO apply(Employee in) {
		
		EmployeeListReadTO out = new EmployeeListReadTO();

		out.setEmployeeId(in.getEmployeeId());
		out.setName(in.getName());
		out.setEmail(in.getEmail());
		out.setJobTitle(in.getJobTitle());
		out.setPhone(in.getPhone());
		out.setImageUrl(in.getImageUrl());
		out.setCode(in.getCode());
		out.setEmployeeChef(in.getEmployeeChef());
		out.setAuthId(in.getAuthId());

		return out;
	}

	public static List<EmployeeListReadTO> apply(List<Employee> in) {
		return in.stream().map(e -> apply(e)).collect(Collectors.toList());
	}
}
