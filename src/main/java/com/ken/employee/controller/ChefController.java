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
import org.springframework.web.bind.annotation.RestController;

import com.ken.employee.model.Chef;
import com.ken.employee.service.ChefService;
import com.ken.employee.transfer.chef.ChefListReadTO;
import com.ken.employee.transfer.chef.ChefReadTO;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/chef")
public class ChefController {

	@Autowired
	private ChefService chefService;

	@ApiOperation("Get All Chefs")
	@GetMapping("/all")
	public List<ChefListReadTO> getAllChef() {
		return chefService.findAll();
	}

	@ApiOperation("Get One Chef")
	@GetMapping("/{id}")
	public ChefReadTO getAllChefById(@ApiParam(name = "ChefId", value = "get One Chef") @PathVariable UUID id) {
		return chefService.getChef(id);
	}
	
	@ApiOperation("Get One Chef")
	@GetMapping("/auth/{id}")
	public ChefReadTO getChefByAuthId(@ApiParam(name = "AuthId", value = "get One Chef") @PathVariable UUID id) {
		return chefService.getChefByAuthId(id);
	}

	@ApiOperation("Add One Chef")
	@PostMapping("")
	public ResponseEntity<Chef> addChef(@ApiParam(name = "Chef", value = "add One Chef") @RequestBody Chef chef) {
		Chef newChef = chefService.addChef(chef);
		return new ResponseEntity<>(newChef, HttpStatus.CREATED);
	}

	@ApiOperation("Add Task(s) to Chef")
	@PutMapping("/{chefId}/addTask")
	public ResponseEntity<ChefReadTO> addTask(
			@ApiParam(name = "ChefId", value = "Id of the Chef") @PathVariable UUID chefId,
			@ApiParam(name = "Ids", value = "Ids of all Tasks") @RequestBody Map<String, ArrayList<UUID>> taskIds) {
		ChefReadTO newChef = chefService.addTask(chefId, taskIds);
		return new ResponseEntity<>(newChef, HttpStatus.OK);
	}

	@ApiOperation("Remove Task(s) to Chef")
	@PutMapping("/{chefId}/removeTask")
	public ResponseEntity<ChefReadTO> removeTask(
			@ApiParam(name = "ChefId", value = "Id of the Chef") @PathVariable UUID chefId,
			@ApiParam(name = "Ids", value = "Ids of all Tasks") @RequestBody Map<String, ArrayList<UUID>> taskIds) {
		ChefReadTO newChef = chefService.removeTask(chefId, taskIds);
		return new ResponseEntity<>(newChef, HttpStatus.OK);
	}

	@ApiOperation("Add Employees(s) to Chef")
	@PutMapping("/{chefId}/addEmployee")
	public ResponseEntity<ChefReadTO> addEmployee(
			@ApiParam(name = "ChefId", value = "Id of the Chef") @PathVariable UUID chefId,
			@ApiParam(name = "Ids", value = "Ids of Employee(s)") @RequestBody Map<String, ArrayList<UUID>> employeeIds) {
		ChefReadTO newChef = chefService.addEmployee(chefId, employeeIds);
		return new ResponseEntity<>(newChef, HttpStatus.OK);
	}

	@ApiOperation("Remove Employees(s) to Chef")
	@PutMapping("/{chefId}/removeEmployee")
	public ResponseEntity<ChefReadTO> removeEmployee(
			@ApiParam(name = "ChefId", value = "Id of the Chef") @PathVariable UUID chefId,
			@ApiParam(name = "Ids", value = "Ids of Employee(s)") @RequestBody Map<String, ArrayList<UUID>> employeeIds) {
		ChefReadTO newChef = chefService.removeEmployee(chefId, employeeIds);
		return new ResponseEntity<>(newChef, HttpStatus.OK);
	}

	@ApiOperation("Update Chef")
	@PutMapping("")
	public ResponseEntity<ChefReadTO> updateChef(@ApiParam(name = "Chef", value = "new Chef") @RequestBody Chef chef) {
		ChefReadTO newChef = chefService.updateChef(chef);
		return new ResponseEntity<>(newChef, HttpStatus.OK);
	}

	@ApiOperation("Delete Chef")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> daleteChef(@ApiParam(name = "ChefId", value = "Id of the Chef") @PathVariable UUID id) {
		return chefService.deleteChef(id);

	}

}
