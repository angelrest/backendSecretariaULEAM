package com.app.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department findByName(String name);
	Optional<Department> findById(Long id);
	
	
}
