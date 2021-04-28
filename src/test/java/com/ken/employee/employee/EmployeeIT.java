package com.ken.employee.employee;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ken.employee.ItBase;
import com.ken.employee.model.Chef;
import com.ken.employee.model.Employee;
import com.ken.employee.model.Task;

import io.restassured.http.ContentType;

public class EmployeeIT extends ItBase {

	Chef chef;

	Task task;

	Employee employee1;

	Employee employee2;

	@BeforeEach
	public void setup() {
		super.setup();

		

		employee1 = buildEmployee(chef);
		employee1 = employeeRepo.save(employee1);

		employee2 = buildEmployee(chef);
		employee2 = employeeRepo.save(employee2);
		
		chef = buildChef();
		chef = chefRepo.save(chef);

		task = buildTask(employee1);
		task = taskRepo.save(task);
	}

	@Override
	//@AfterAll
	public void cleanup() {
		super.cleanup();
	}

	@Test
	public void create() {
		Chef chef = buildChef();
		chef = chefRepo.save(chef);

		Employee create = buildEmployee(chef);
		
		UUID id = UUID.fromString(given()
                .contentType(ContentType.JSON)
                .body(create)
                .log().body()
                .post("/employee")
                .then()
                .log().body()
                .statusCode(201)
                .extract().body().path("employeeId"));

		Employee employee = employeeRepo.findById(id).get();

		assertThat(create.getName(), is(employee.getName()));
		assertThat(create.getEmail(), is(employee.getEmail()));
		assertThat(create.getJobTitle(), is(employee.getJobTitle()));
		assertThat(create.getPhone(), is(employee.getPhone()));
		assertThat(create.getImageUrl(), is(employee.getImageUrl()));
		assertThat(create.getEmployeeChef().getChefId(), is(employee.getEmployeeChef().getChefId()));
		assertThat(create.getEmployeeChef().getName(), is(employee.getEmployeeChef().getName()));
		assertThat(create.getEmployeeChef().getEmail(), is(employee.getEmployeeChef().getEmail()));
		assertThat(create.getEmployeeChef().getDepartment(), is(employee.getEmployeeChef().getDepartment()));
		assertThat(create.getEmployeeChef().getPhone(), is(employee.getEmployeeChef().getPhone()));
		assertThat(create.getEmployeeChef().getImageUrl(), is(employee.getEmployeeChef().getImageUrl()));
	}
	
	@Test
	public void update() {
		Chef chef = buildChef();
		chef = chefRepo.save(chef);

		Employee update = buildEmployee(chef);	
		
		given()
                .contentType(ContentType.JSON)
                .body(update)
                .log().body()
                .put("/employee/{id}", employee1.getEmployeeId())
                .then()
                .log().body()
                .statusCode(200);

		Employee employee = employeeRepo.findById(employee1.getEmployeeId()).get();

		assertThat(update.getName(), is(employee.getName()));
		assertThat(update.getEmail(), is(employee.getEmail()));
		assertThat(update.getJobTitle(), is(employee.getJobTitle()));
		assertThat(update.getPhone(), is(employee.getPhone()));
		assertThat(update.getImageUrl(), is(employee.getImageUrl()));
		assertThat(update.getEmployeeChef().getChefId(), is(employee.getEmployeeChef().getChefId()));
		assertThat(update.getEmployeeChef().getName(), is(employee.getEmployeeChef().getName()));
		assertThat(update.getEmployeeChef().getEmail(), is(employee.getEmployeeChef().getEmail()));
		assertThat(update.getEmployeeChef().getDepartment(), is(employee.getEmployeeChef().getDepartment()));
		assertThat(update.getEmployeeChef().getPhone(), is(employee.getEmployeeChef().getPhone()));
		assertThat(update.getEmployeeChef().getImageUrl(), is(employee.getEmployeeChef().getImageUrl()));
	}

}
