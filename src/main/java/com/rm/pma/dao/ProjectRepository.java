package com.rm.pma.dao;

import com.rm.pma.dto.ChartData;
import com.rm.pma.dto.Revenue;
import com.rm.pma.dto.Timelines;
import com.rm.pma.entities.Project;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProjectRepository extends PagingAndSortingRepository<Project,Long> {
    @Override
    List<Project> findAll();
    @Query(nativeQuery = true, value = "SELECT stage AS label, Count(*)  AS val " +
            "FROM project " +
            "GROUP BY stage")
    public List<ChartData> getProjectStatus();
    @Query(nativeQuery = true, value = "SELECT name AS projectName, start_date AS startDate, end_date AS endDate FROM project WHERE start_date is not null")
    public List<Timelines> getTimelines();
    @Query(nativeQuery = true, value = "SELECT name AS projectName, predicted_revenue AS predictedRevenue, actual_revenue AS actualRevenue FROM project")
    public List<Revenue> getRevenue();





}
