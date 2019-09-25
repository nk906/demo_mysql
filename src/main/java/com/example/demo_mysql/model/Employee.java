package com.example.demo_mysql.model;

import org.springframework.data.annotation.Id;

public class Employee{
	
	Employee(){}
	
	public Employee(Integer id, String firstName, String lastName, String email) {
		this.id = id;
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
	}
	
	@Id
	Integer id;
	String first_name;
	String last_name;
	String email;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
				+ "]";
	}
	
}