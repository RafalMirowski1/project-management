package com.rm.pma.services;

import com.rm.pma.dao.EmployeeRepository;
import com.rm.pma.dto.EmployeeProject;
import com.rm.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public List<EmployeeProject> employeeProjects(){
        return employeeRepository.employeeProjects();
    }
    public Employee getEmployeebyId(Long id){
        return employeeRepository.findById(id).get();
    }
    public void deleteEmployeeById(Long id){
         employeeRepository.deleteById(id);
    }
    public Employee findByEmail(String email){
        return employeeRepository.findByEmailAddress(email);

    }

}
