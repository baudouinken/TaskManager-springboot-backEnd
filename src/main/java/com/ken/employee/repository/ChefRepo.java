package com.ken.employee.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ken.employee.model.Chef;

@Repository
public interface ChefRepo extends JpaRepository<Chef, UUID> {
	
	Chef findByAuthId(UUID id);

}
