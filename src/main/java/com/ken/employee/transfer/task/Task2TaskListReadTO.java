package com.ken.employee.transfer.task;

import java.util.List;
import java.util.stream.Collectors;

import com.ken.employee.model.Task;

public class Task2TaskListReadTO {

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

		return out;
	}

	public static List<TaskListReadTO> apply(List<Task> in) {
		return in.stream().map(e -> apply(e)).collect(Collectors.toList());
	}

}
