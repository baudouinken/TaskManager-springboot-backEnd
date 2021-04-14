package com.ken.employee.transfer.chef;

import java.util.ArrayList;
import java.util.List;

import com.ken.employee.transfer.employee.EmployeeListReadTO;
import com.ken.employee.transfer.task.TaskListReadTO;

public class ChefReadTO extends ChefListReadTO {

	private List<TaskListReadTO> tasks = new ArrayList<>();

	private List<EmployeeListReadTO> employees = new ArrayList<>();

	public List<TaskListReadTO> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskListReadTO> tasks) {
		this.tasks = tasks;
	}

	public List<EmployeeListReadTO> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeListReadTO> employees) {
		this.employees = employees;
	}

}
