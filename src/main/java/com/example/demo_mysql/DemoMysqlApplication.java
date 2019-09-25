package com.example.demo_mysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo_mysql.repository.EmployeeRepository;
import com.example.demo_mysql.model.Employee;

@SpringBootApplication
public class DemoMysqlApplication implements CommandLineRunner{
	
	@Autowired
	private EmployeeRepository empRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoMysqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("PRoces started");
		for(Employee emp : empRepo.findByLastName("kumari")) {
			System.out.println(emp);
		}
	}

}
