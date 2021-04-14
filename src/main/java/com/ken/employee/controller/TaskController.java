package com.ken.employee.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ken.employee.model.Task;
import com.ken.employee.service.TaskService;
import com.ken.employee.transfer.task.TaskListReadTO;
import com.ken.employee.transfer.task.TaskReadTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;

	@ApiOperation("Get All Tasks")
	@GetMapping("/all")
	public List<TaskListReadTO> getAllTask() {
		return taskService.findAll();

	}

	@ApiOperation("Get One Task")
	@GetMapping("/{id}")
	public TaskReadTO getAllTaskById(@ApiParam(name = "Id", value = "Id of the Task") @PathVariable UUID id) {
		return taskService.getTask(id);
	}

	@ApiOperation("Add One Task")
	@PostMapping("")
	public ResponseEntity<Task> addTask(@ApiParam(name = "Task", value = "New Task") @RequestBody Task task) {
		Task newTask = taskService.addTask(task);
		return new ResponseEntity<>(newTask, HttpStatus.CREATED);
	}

	@ApiOperation("set one Task as started")
	@PutMapping("/start/{taskId}")
	public ResponseEntity<TaskReadTO> startTask(@ApiParam(name = "Id", value = "Id of the Task") @PathVariable UUID taskId) {
		TaskReadTO newTask = taskService.startTask(taskId);
		return new ResponseEntity<>(newTask, HttpStatus.OK);
	}

	@ApiOperation("set One Task as terminated")
	@PutMapping("/terminate{taskId}")
	public ResponseEntity<TaskReadTO> terminateTask(
			@ApiParam(name = "Id", value = "Id of the Task") @PathVariable UUID taskId) {
		TaskReadTO newTask = taskService.terminateTask(taskId);
		return new ResponseEntity<>(newTask, HttpStatus.OK);
	}

	@ApiOperation("Update One Task")
	@PutMapping("")
	public ResponseEntity<Task> updateTask(@ApiParam(name = "Task", value = "New Task") @RequestBody Task task) {
		Task newTask = taskService.updateTask(task);
		return new ResponseEntity<>(newTask, HttpStatus.OK);
	}

	@ApiOperation("Delete one Task")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> daleteTask(@ApiParam(name = "Id", value = "Id of the Task") @PathVariable UUID id) {
		return taskService.deleteTask(id);

	}

}
