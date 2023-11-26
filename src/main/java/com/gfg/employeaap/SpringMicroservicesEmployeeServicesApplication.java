package com.gfg.employeaap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SpringMicroservicesEmployeeServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMicroservicesEmployeeServicesApplication.class, args);
	}

}
