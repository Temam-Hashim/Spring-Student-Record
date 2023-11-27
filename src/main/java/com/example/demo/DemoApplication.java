package com.example.demo;

import com.example.demo.configuration.FlywayRepairService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class DemoApplication {
	@Autowired
	private FlywayRepairService flywayRepairService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@PostConstruct
	public void runFlywayRepair() {
		flywayRepairService.performRepair();
	}
}
