package com.example.demo_mysql.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo_mysql.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
	
	@Query("SELECT * FROM Employee e where e.last_name = :last_name")
	public List<Employee> findByLastName(@Param("last_name") String last_name);
}
