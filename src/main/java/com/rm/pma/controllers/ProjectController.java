package com.rm.pma.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rm.pma.dao.EmployeeRepository;
import com.rm.pma.dao.ProjectRepository;
import com.rm.pma.dto.Revenue;
import com.rm.pma.dto.Timelines;
import com.rm.pma.entities.Employee;
import com.rm.pma.entities.Project;
import com.rm.pma.services.EmployeeService;
import com.rm.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public String displayProjects(Model model){
        List<Project> projectList = projectService.getAll();
        model.addAttribute("projectList",projectList);
        return "projects/list-projects";

    }
    @GetMapping("/new")
    public String displayProjectForm(Model model){
        model.addAttribute("project", new Project());
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("allEmployees", employees);
        return "projects/new-project";
    }
    @PostMapping("/save")
    public String createProject(@Valid Project project, Model model, Errors errors){
        model.addAttribute("project",project);

        if (errors.hasErrors()){
            return "projects/new-project";
        }
       projectService.save(project);
        return "redirect:/projects/";
    }
    @GetMapping("/update")
    public String displayProjectUpdateForm(@RequestParam("id") long id,Model model
                                           ){
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("allEmployees",employees);
        Project project = projectService.getProjectById(id);
        model.addAttribute("project",project);
        return "projects/new-project";
    }
    @GetMapping("/delete")
    public String deleteProject(@RequestParam("id") long id ,Model model){
        projectService.deleteProjectById(id);
        return "redirect:/projects/";
    }
    @GetMapping("/timelines")
    public String displayProjectTimelines(Model model) throws JsonProcessingException {
        List<Timelines> timelinesList= projectService.getTimelines();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonTimelines = objectMapper.writeValueAsString(timelinesList);
        model.addAttribute("timelinesList",jsonTimelines);
        return "projects/project-timelines";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor( Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true, 10));
    }
    @GetMapping("/revenue")
    public String displayProjectRevenue(Model model) throws JsonProcessingException{
        List<Revenue> revenueList=projectService.getRevenue();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRevenue = objectMapper.writeValueAsString(revenueList);
        model.addAttribute("revenueList",jsonRevenue);
        System.out.println(jsonRevenue);
        return "projects/project-revenue";

    }
}
