package com.example.demo_mysql.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoMysqlApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoMysqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("PRoces started");
	}

}
