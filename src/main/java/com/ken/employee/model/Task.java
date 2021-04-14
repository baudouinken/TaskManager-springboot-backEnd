package com.ken.employee.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6965397530285110827L;

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(nullable = false, updatable = false)
	private UUID taskId;

	@NotBlank
	private String name;

	@NotBlank
	private String department;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

	private boolean terminated;

	private boolean inProgress;

	private boolean started;

	private String code;

	@ManyToMany
	@JoinTable(name = "task_chefs", joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "taskId"), inverseJoinColumns = @JoinColumn(name = "chef_id", referencedColumnName = "chefId"))
	private List<Chef> taskChefs;

	@ManyToOne
	@JoinColumn(name = "employee_Id")
	private Employee attribuatedEmployee;

	public Task() {
		// TODO Auto-generated constructor stub
	}

	public Task(@NotBlank String name, @NotBlank String department, @NotBlank LocalDateTime startDate,
			@NotBlank LocalDateTime endDate, String code) {
		this.name = name;
		this.department = department;
		this.startDate = startDate;
		this.endDate = endDate;
		this.terminated = false;
		this.inProgress = false;
		this.started = false;
		this.code = code;
	}

	public UUID getTaskId() {
		return taskId;
	}

	public void setTaskId(UUID taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public boolean isTerminated() {
		return terminated;
	}

	public void setTerminated(boolean terminated) {
		this.terminated = terminated;
	}

	public boolean isInProgress() {
		return inProgress;
	}

	public void setInProgress(boolean inProgress) {
		this.inProgress = inProgress;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Chef> getTaskChefs() {
		return taskChefs;
	}

	public void setTaskChefs(List<Chef> taskChefs) {
		this.taskChefs = taskChefs;
	}

	public Employee getAttribuatedEmployee() {
		return attribuatedEmployee;
	}

	public void setAttribuatedEmployee(Employee attribuatedEmployee) {
		this.attribuatedEmployee = attribuatedEmployee;
	}

}
