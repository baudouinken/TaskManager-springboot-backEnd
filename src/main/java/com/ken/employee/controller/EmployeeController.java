package com.ken.employee.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ken.employee.model.Employee;
import com.ken.employee.service.EmployeeService;
import com.ken.employee.transfer.employee.EmployeeListReadTO;
import com.ken.employee.transfer.employee.EmployeeReadTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@ApiOperation("Get all Employees")
	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	public List<EmployeeListReadTO> getAllEmployee() {
		return employeeService.findAll();
	}

	@ApiOperation("Get One Employee")
	@GetMapping("/{id}")
	public EmployeeReadTO getAllEmployeeById(
			@ApiParam(name = "Id", value = "Id of the employee") @PathVariable UUID id) {
		return employeeService.getEmployee(id);
	}

	@ApiOperation("Add One Employee")
	@PostMapping("")
	public ResponseEntity<EmployeeReadTO> addEmployee(
			@ApiParam(name = "Employee", value = "new employee") @RequestBody Employee employee) {
		EmployeeReadTO newEmployee = employeeService.addEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
	}

	@ApiOperation("Add Task(s) to one Employee")
	@PutMapping("/{employeeId}/addTask")
	public ResponseEntity<EmployeeReadTO> addTask(
			@ApiParam(name = "Id", value = "Id of the employee") @PathVariable UUID employeeId,
			@ApiParam(name = "Ids", value = "Ids of Task(s)") @RequestBody Map<String, ArrayList<UUID>> taskIds) {
		EmployeeReadTO newEmployee = employeeService.addTask(employeeId, taskIds);
		return new ResponseEntity<>(newEmployee, HttpStatus.OK);
	}

	@ApiOperation("Remove Task(s) to one Employee")
	@PutMapping("/{employeeId}/removeTask")
	public ResponseEntity<EmployeeReadTO> removeTask(
			@ApiParam(name = "Id", value = "Id of the employee") @PathVariable UUID employeeId,
			@ApiParam(name = "Id(s)", value = "Id(s) of Task(s)") @RequestBody Map<String, ArrayList<UUID>> taskIds) {
		EmployeeReadTO newEmployee = employeeService.removeTask(employeeId, taskIds);
		return new ResponseEntity<>(newEmployee, HttpStatus.OK);
	}

	@ApiOperation("Update one Employee")
	@PutMapping("")
	public ResponseEntity<EmployeeReadTO> updateEmployee(
			@ApiParam(name = "Employee", value = "New the employee") @RequestBody Employee employee) {
		EmployeeReadTO newEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(newEmployee, HttpStatus.OK);
	}

	@ApiOperation("Delete one Employee")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> daleteEmployee(
			@ApiParam(name = "Id", value = "Id of the employee") @PathVariable UUID id) {
		return employeeService.deleteEmployee(id);

	}

}
