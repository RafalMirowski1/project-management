package com.rm.pma.services;

import com.rm.pma.dao.ProjectRepository;
import com.rm.pma.dto.ChartData;
import com.rm.pma.dto.Revenue;
import com.rm.pma.dto.Timelines;
import com.rm.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    public Project save(Project project){
        return projectRepository.save(project);
    }
    public List<Project> getAll(){
        return projectRepository.findAll();
    }
    public List<ChartData> getProjectStatus(){
        return projectRepository.getProjectStatus();
    }
    public Project getProjectById(Long id){
        return projectRepository.findById(id).get();
    }
    public void deleteProjectById(Long id){
        projectRepository.deleteById(id);
    }
    public List<Timelines> getTimelines(){
        return projectRepository.getTimelines();
    }
    public List<Revenue> getRevenue(){
        return projectRepository.getRevenue();
    }

}
