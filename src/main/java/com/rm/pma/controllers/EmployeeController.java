package com.rm.pma.controllers;

import com.rm.pma.dao.EmployeeRepository;
import com.rm.pma.entities.Employee;
import com.rm.pma.entities.Project;
import com.rm.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/")
    public String displayEmployees(Model model){
        List<Employee> employeeList = employeeService.getAll();
        model.addAttribute("employeeList",employeeList);
        return "employees/list-employees";

    }
    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        model.addAttribute("employee", new Employee());
        return "employees/new-employee";
    }
    @PostMapping("/save")
    public String createEmployee(Model model,@Valid Employee employee, Errors errors){
        model.addAttribute("employee",employee);
        employeeService.save(employee);

        if(errors.hasErrors()){
            return "employees/new-employee";
        }
        return "redirect:/employees/";
    }
    @GetMapping("/update")
    public String  displayUpdateEmployee(@RequestParam("id") long id,Model model){

        Employee employee = employeeService.getEmployeebyId(id);
        model.addAttribute("employee",employee);
        return "employees/new-employee";

    }
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("id") long id,Model model){
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees/";
    }

}
