package com.rm.pma.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq",
            allocationSize = 1,initialValue=1)
    private long projectId;
    private String name;
    private String stage;
    private String description;
    private long predictedRevenue;
    private long actualRevenue;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date startDate;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date endDate;
    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},
            fetch = FetchType.LAZY)
    @JoinTable(name = "project_employee",
            joinColumns = @JoinColumn(name = "projectId"),
            inverseJoinColumns = @JoinColumn(name = "employeeId"))
    @JsonIgnore
    private List<Employee> employees;
    public Project(){};

    public Project(String name, String stage, String description) {
        this.name = name;
        this.stage = stage;
        this.description = description;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getPredictedRevenue() {
        return predictedRevenue;
    }

    public void setPredictedRevenue(long predictedRevenue) {
        this.predictedRevenue = predictedRevenue;
    }

    public long getActualRevenue() {
        return actualRevenue;
    }

    public void setActualRevenue(long actualRevenue) {
        this.actualRevenue = actualRevenue;
    }
    public void addEmployee(Employee emp1) {
        if (employees==null){
            employees=new ArrayList<>();
        }
        employees.add(emp1);
    }
}
