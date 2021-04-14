package com.ken.employee.transfer.employee;

import java.util.ArrayList;
import java.util.List;

import com.ken.employee.transfer.task.TaskListReadTO;

public class EmployeeReadTO extends EmployeeListReadTO {

	private List<TaskListReadTO> tasks = new ArrayList<TaskListReadTO>();

	public List<TaskListReadTO> getTasks() {
		return tasks;
	}

	public void setTasks(List<TaskListReadTO> tasks) {
		this.tasks = tasks;
	}

}
