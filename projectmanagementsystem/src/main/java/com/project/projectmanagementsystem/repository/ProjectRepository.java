package com.project.projectmanagementsystem.repository;

import com.project.projectmanagementsystem.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}