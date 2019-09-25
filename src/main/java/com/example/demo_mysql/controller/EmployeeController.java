package com.example.demo_mysql.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo_mysql.model.Employee;
import com.example.demo_mysql.repository.EmployeeRepository;

@RestController
public class EmployeeController{
	
	@Autowired private EmployeeRepository empRepo;
	
	@GetMapping("/show")
	public List<Employee> getAllEmployees(){
		List<Employee> list = new ArrayList<Employee>();
		for(Employee e: empRepo.findAll()) {
			list.add(e);
		}
		return list;
	}
	
	@GetMapping("/show/{id}")
	public Employee getEmployeeById(@PathVariable(value = "id") Integer id) {
		try {
			return empRepo.findById(id)
					.orElseThrow(()-> new Exception("employee not found"));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/create")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		try {
			return empRepo.save(emp);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer id, @Valid @RequestBody Employee emp) {
		try {
			Employee e = empRepo.findById(id)
					.orElseThrow(()-> new Exception("employee not found"));
			e.setEmail(emp.getEmail());
			e.setFirst_name(emp.getFirst_name());
			e.setLast_name(emp.getLast_name());
			return ResponseEntity.ok(empRepo.save(e));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value="id") Integer id) throws Exception{
		Employee e = empRepo.findById(id)
				.orElseThrow(()-> new Exception("employee not found"));
		empRepo.delete(e);
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("deleted", true);
		return map;
	}

}
