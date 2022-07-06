package com.rm.pma.dao;

import com.rm.pma.dto.EmployeeProject;
import com.rm.pma.entities.Employee;
import com.rm.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    @Override
    List<Employee> findAll();
    @Query(nativeQuery = true, value = "SELECT first_name AS firstName, last_name AS lastName, COUNT(project_employee.employee_id) AS projectCount " +
            "FROM employee " +
            "LEFT JOIN project_employee " +
            "ON project_employee.employee_id=employee.employee_id " +
            "GROUP BY first_name, last_name " +
            "ORDER BY 3 DESC")
    public List<EmployeeProject> employeeProjects();
    public Employee findByEmailAddress(String email);





}
