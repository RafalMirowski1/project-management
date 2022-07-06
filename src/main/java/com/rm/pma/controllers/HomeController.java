package com.rm.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rm.pma.dao.EmployeeRepository;
import com.rm.pma.dao.ProjectRepository;
import com.rm.pma.dto.EmployeeProject;
import com.rm.pma.dto.ChartData;
import com.rm.pma.entities.Project;
import com.rm.pma.services.EmployeeService;
import com.rm.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;


@Controller

public class HomeController {
    @Autowired
    ProjectService projectService;
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public String displayHome(Model model) throws JsonProcessingException {
        List<Project> projectList = projectService.getAll();
        List<EmployeeProject> employeeList = employeeService.employeeProjects();
        List<ChartData> statusCountList = projectService.getProjectStatus();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(statusCountList);


        model.addAttribute("projectStatusCount",jsonString);
        model.addAttribute("projectList",projectList);
        model.addAttribute("employeeList",employeeList);
        return "main/home";

    }
}
