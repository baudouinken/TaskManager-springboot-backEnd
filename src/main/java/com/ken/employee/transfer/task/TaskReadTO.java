package com.ken.employee.transfer.task;

import java.util.List;

import com.ken.employee.transfer.chef.ChefListReadTO;
import com.ken.employee.transfer.employee.EmployeeListReadTO;

public class TaskReadTO extends TaskListReadTO {

	private List<ChefListReadTO> taskChefs;

	private EmployeeListReadTO attribuatedEmployee;

	public List<ChefListReadTO> getTaskChefs() {
		return taskChefs;
	}

	public void setTaskChefs(List<ChefListReadTO> taskChefs) {
		this.taskChefs = taskChefs;
	}

	public EmployeeListReadTO getAttribuatedEmployee() {
		return attribuatedEmployee;
	}

	public void setAttribuatedEmployee(EmployeeListReadTO attribuatedEmployee) {
		this.attribuatedEmployee = attribuatedEmployee;
	}

}
