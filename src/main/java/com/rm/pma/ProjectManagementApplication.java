package com.rm.pma;

import com.rm.pma.dao.EmployeeRepository;
import com.rm.pma.dao.ProjectRepository;
import com.rm.pma.entities.Employee;
import com.rm.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class ProjectManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}



}
