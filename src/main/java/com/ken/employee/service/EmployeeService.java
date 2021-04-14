package com.ken.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ken.employee.model.Employee;
import com.ken.employee.model.Task;
import com.ken.employee.repository.EmployeeRepo;
import com.ken.employee.repository.TaskRepo;
import com.ken.employee.transfer.employee.Employee2EmployeeListReadTO;
import com.ken.employee.transfer.employee.Employee2EmployeeReadTO;
import com.ken.employee.transfer.employee.EmployeeListReadTO;
import com.ken.employee.transfer.employee.EmployeeReadTO;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeerepo;

	@Autowired
	private TaskRepo taskrepo;

	@Autowired
	private TaskService taskService;

	public EmployeeReadTO addEmployee(Employee employee) {
		employee.setCode(UUID.randomUUID().toString());

		return Employee2EmployeeReadTO.apply(employeerepo.save(employee));
	}

	public EmployeeReadTO getEmployee(UUID id) {
		return Employee2EmployeeReadTO.apply(findEmployee(id));
	}

	public Employee findEmployee(UUID id) {
		return employeerepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public List<EmployeeListReadTO> findAll() {
		return Employee2EmployeeListReadTO.apply(employeerepo.findAll());
	}

	public EmployeeReadTO updateEmployee(Employee employee) {
		return Employee2EmployeeReadTO.apply(employeerepo.save(employee));
	}

	public ResponseEntity<?> deleteEmployee(UUID id) {
		employeerepo.deleteById(id);
		return ResponseEntity.ok("Successfully deleted");
	}

	public EmployeeReadTO addTask(UUID employeeId, Map<String, ArrayList<UUID>> taskIds) {

		Employee employee = findEmployee(employeeId);
		ArrayList<UUID> ids = taskIds.get("taskIds");

		for (UUID taskId : ids) {
			Task task = taskrepo.getOne(taskId);
			employee.getTasks().add(task);
			task.setAttribuatedEmployee(employee);
			taskrepo.save(task);
			employeerepo.save(employee);
		}

		return Employee2EmployeeReadTO.apply(employee);
	}

	public EmployeeReadTO removeTask(UUID employeeId, Map<String, ArrayList<UUID>> taskIds) {

		Employee employee = findEmployee(employeeId);
		ArrayList<UUID> ids = taskIds.get("taskIds");

		for (UUID taskId : ids) {
			Task task = taskrepo.getOne(taskId);
			employee.getTasks().remove(task);
			task.setAttribuatedEmployee(null);
			taskrepo.save(task);
			employeerepo.save(employee);
		}
		return Employee2EmployeeReadTO.apply(employee);
	}

}
