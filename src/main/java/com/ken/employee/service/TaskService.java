package com.ken.employee.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ken.employee.model.Task;
import com.ken.employee.repository.TaskRepo;
import com.ken.employee.transfer.task.Task2TaskListReadTO;
import com.ken.employee.transfer.task.Task2TaskReadTO;
import com.ken.employee.transfer.task.TaskListReadTO;
import com.ken.employee.transfer.task.TaskReadTO;

@Service
public class TaskService {

	@Autowired
	private TaskRepo taskrepo;

	public Task addTask(Task task) {
		task.setCode(UUID.randomUUID().toString());

		return taskrepo.save(task);
	}

	public TaskReadTO getTask(UUID id) {
		return Task2TaskReadTO.apply(findTask(id));
	}

	public Task findTask(UUID id) {
		return taskrepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public List<TaskListReadTO> findAll() {
		return Task2TaskListReadTO.apply(taskrepo.findAll());
	}

	public Task updateTask(Task task) {
		return taskrepo.save(task);
	}

	public ResponseEntity<?> deleteTask(UUID id) {
		taskrepo.deleteById(id);
		return ResponseEntity.ok("Successfully deleted");
	}

	public TaskReadTO startTask(UUID taskId) {
		Task task = findTask(taskId);
		task.setStartDate(LocalDateTime.now());
		task.setStarted(true);
		task.setTerminated(false);
		taskrepo.save(task);
		return Task2TaskReadTO.apply(task);
	}

	public TaskReadTO terminateTask(UUID taskId) {
		Task task = findTask(taskId);
		task.setEndDate(LocalDateTime.now());
		task.setTerminated(true);
		task.setStarted(false);
		taskrepo.save(task);
		return Task2TaskReadTO.apply(task);
	}

}
