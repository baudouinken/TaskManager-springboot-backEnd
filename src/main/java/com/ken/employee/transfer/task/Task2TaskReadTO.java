package com.ken.employee.transfer.task;

import java.util.ArrayList;

import com.ken.employee.model.Task;
import com.ken.employee.transfer.chef.Chef2ChefListReadTO;
import com.ken.employee.transfer.employee.Employee2EmployeeListReadTO;

public class Task2TaskReadTO {

	public static TaskReadTO apply(Task in) {
		TaskReadTO out = new TaskReadTO();
		out.setTaskId(in.getTaskId());
		out.setName(in.getName());
		out.setDepartment(in.getDepartment());
		out.setStartDate(in.getStartDate());
		out.setEndDate(in.getEndDate());
		out.setTerminated(in.isTerminated());
		out.setInProgress(in.isInProgress());
		out.setStarted(in.isStarted());
		out.setCode(in.getCode());
		out.setAttribuatedEmployee(Employee2EmployeeListReadTO.apply(in.getAttribuatedEmployee()));
		out.setTaskChefs(
				in.getTaskChefs() != null ? Chef2ChefListReadTO.apply(new ArrayList<>(in.getTaskChefs())) : null);

		return out;
	}

}
