package com.ken.employee;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ken.employee.model.Chef;
import com.ken.employee.model.Employee;
import com.ken.employee.model.Task;
import com.ken.employee.repository.ChefRepo;
import com.ken.employee.repository.EmployeeRepo;
import com.ken.employee.repository.TaskRepo;
import com.ken.employee.transfer.chef.ChefReadTO;
import com.ken.employee.transfer.employee.EmployeeListReadTO;
import com.ken.employee.transfer.employee.EmployeeReadTO;
import com.ken.employee.transfer.task.TaskReadTO;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ItBase {

	@Autowired
	private WebApplicationContext wac;

	protected MockMvc mockMvc;

	protected MockHttpSession session;

	@Autowired
	protected EmployeeRepo employeeRepo;

	@Autowired
	protected ChefRepo chefRepo;

	@Autowired
	protected TaskRepo taskRepo;

	@BeforeEach
	public void setup() {
		this.session = new MockHttpSession();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		RestAssuredMockMvc.webAppContextSetup(wac);
	}

	public void cleanup() {
		employeeRepo.deleteAll();
		chefRepo.deleteAll();
		taskRepo.deleteAll();
	}

	protected Chef buildChef() {

		Chef item = new Chef();
		
		item.setDepartment("Departement-" + UUID.randomUUID());
		item.setEmail("Email-" + UUID.randomUUID());
		item.setImageUrl("Url-" + UUID.randomUUID());
		item.setName("Name-" + UUID.randomUUID());
		item.setPhone("Phone" + UUID.randomUUID());

		return item;
	}

	protected Employee buildEmployee(Chef chef) {
		Employee item = new Employee();
		
		item.setEmail("Email-" + UUID.randomUUID());
		item.setImageUrl("Url-" + UUID.randomUUID());
		item.setJobTitle("Job-" + UUID.randomUUID());
		item.setName("Name-" + UUID.randomUUID());
		item.setPhone("Phone" + UUID.randomUUID());
		item.setEmployeeChef(chef);
		return item;
	}

	protected Task buildTask(Employee employee) {
		Task item = new Task();
		
		item.setAttribuatedEmployee(employee);
		item.setDepartment("Departement-" + UUID.randomUUID());
		item.setEndDate(null);
		item.setInProgress(true);
		item.setName("Name-" + UUID.randomUUID());
		item.setStartDate(null);
		item.setStarted(true);
		item.setTerminated(false);
		return item;
	}

	protected EmployeeReadTO buildEmployeeList(Chef chef) {

		EmployeeReadTO item = new EmployeeReadTO();
		
		item.setEmail("Email-" + UUID.randomUUID());
		item.setEmployeeChef(chef);
		item.setImageUrl("Url-" + UUID.randomUUID());
		item.setJobTitle("Job-" + UUID.randomUUID());
		item.setName("Name-" + UUID.randomUUID());
		item.setPhone("Phone" + UUID.randomUUID());

		return item;
	}

	protected TaskReadTO buildTaskReadTO(EmployeeListReadTO employee) {
		TaskReadTO item = new TaskReadTO();
		
		item.setAttribuatedEmployee(employee);
		item.setDepartment("Departement-" + UUID.randomUUID());
		item.setEndDate(null);
		item.setInProgress(true);
		item.setName("Name-" + UUID.randomUUID());
		item.setStartDate(null);
		item.setStarted(true);
		item.setTerminated(false);
		return item;
	}

	protected ChefReadTO buildChefReadTO() {
		ChefReadTO item = new ChefReadTO();
		
		item.setDepartment("Departement-" + UUID.randomUUID());
		item.setEmail("Email-" + UUID.randomUUID());
		item.setImageUrl("Url-" + UUID.randomUUID());
		item.setName("Name-" + UUID.randomUUID());
		item.setPhone("Phone" + UUID.randomUUID());
		return item;
	}

}
