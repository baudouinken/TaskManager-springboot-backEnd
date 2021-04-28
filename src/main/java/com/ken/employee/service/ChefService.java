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

import com.ken.employee.model.Chef;
import com.ken.employee.model.Employee;
import com.ken.employee.model.Task;
import com.ken.employee.repository.ChefRepo;
import com.ken.employee.repository.EmployeeRepo;
import com.ken.employee.repository.TaskRepo;
import com.ken.employee.transfer.chef.Chef2ChefListReadTO;
import com.ken.employee.transfer.chef.Chef2ChefReadTO;
import com.ken.employee.transfer.chef.ChefListReadTO;
import com.ken.employee.transfer.chef.ChefReadTO;

@Service
public class ChefService {

	@Autowired
	private ChefRepo chefrepo;

	@Autowired
	private TaskRepo taskrepo;

	@Autowired
	private EmployeeRepo employeeRepo;

	public Chef addChef(Chef chef) {
		chef.setCode(UUID.randomUUID().toString());

		return chefrepo.save(chef);
	}

	public ChefReadTO getChef(UUID id) {
		return Chef2ChefReadTO.apply(findChef(id));
	}
	
	public ChefReadTO getChefByAuthId(UUID id) {
		return Chef2ChefReadTO.apply(findChefByAuthId(id));
	}

	public Chef findChef(UUID id) {
		return chefrepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public Chef findChefByAuthId(UUID id) {
		return chefrepo.findByAuthId(id);
	}

	public List<ChefListReadTO> findAll() {
		return Chef2ChefListReadTO.apply(chefrepo.findAll());
	}

	public Chef updateChef(Chef chef) {
		return chefrepo.save(chef);
	}

	public ResponseEntity<?> deleteChef(UUID id) {
		chefrepo.deleteById(id);
		return ResponseEntity.ok("Successfully deleted");
	}

	public ChefReadTO addTask(UUID chefId, Map<String, ArrayList<UUID>> taskIds) {

		Chef chef = findChef(chefId);
		ArrayList<UUID> ids = taskIds.get("taskIds");

		for (UUID taskId : ids) {
			Task task = taskrepo.getOne(taskId);
			chef.getTasks().add(task);
			task.getTaskChefs().add(chef);
			taskrepo.save(task);
			chefrepo.save(chef);
			System.out.println(task.getTaskChefs());
		}

		return Chef2ChefReadTO.apply(chef);
	}

	public ChefReadTO removeTask(UUID chefId, Map<String, ArrayList<UUID>> taskIds) {

		Chef chef = findChef(chefId);
		ArrayList<UUID> ids = taskIds.get("taskIds");

		for (UUID taskId : ids) {
			Task task = taskrepo.getOne(taskId);
			chef.getTasks().remove(task);
			task.getTaskChefs().remove(chef);
			taskrepo.save(task);
			chefrepo.save(chef);
		}
		return Chef2ChefReadTO.apply(chef);
	}

	public ChefReadTO addEmployee(UUID chefId, Map<String, ArrayList<UUID>> employeeIds) {

		Chef chef = findChef(chefId);
		ArrayList<UUID> ids = employeeIds.get("employeeIds");

		for (UUID employeeId : ids) {
			Employee employee = employeeRepo.getOne(employeeId);
			chef.getEmployees().add(employee);
			employee.setEmployeeChef(chef);
			employeeRepo.save(employee);
			chefrepo.save(chef);
		}
		return Chef2ChefReadTO.apply(chef);
	}

	public ChefReadTO removeEmployee(UUID chefId, Map<String, ArrayList<UUID>> employeeIds) {

		Chef chef = findChef(chefId);
		ArrayList<UUID> ids = employeeIds.get("employeeIds");

		for (UUID employeeId : ids) {
			Employee employee = employeeRepo.getOne(employeeId);
			chef.getEmployees().remove(employee);
			employee.setEmployeeChef(null);
			employeeRepo.save(employee);
			chefrepo.save(chef);
		}
		return Chef2ChefReadTO.apply(chef);
	}

}
