package com.project.projectmanagementsystem.controller;

import com.project.projectmanagementsystem.entity.Project;
import com.project.projectmanagementsystem.repository.EmployeeRepository;
import com.project.projectmanagementsystem.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/addProject")
    public String showProjectForm(Model model) {

        model.addAttribute("project", new Project());

        model.addAttribute("employees", employeeRepository.findAll());

        return "addProject";
    }

    @PostMapping("/saveProject")
    public String saveProject(@ModelAttribute Project project) {

        projectRepository.save(project);

        return "redirect:/projects";
    }

    @GetMapping("/projects")
    public String viewProjects(Model model) {

        model.addAttribute("projects", projectRepository.findAll());

        return "projectList";
    }

    @GetMapping("/editProject/{id}")
    public String editProject(@PathVariable int id, Model model) {

        Project project = projectRepository.findById(id).orElse(null);

        model.addAttribute("project", project);

        model.addAttribute("employees", employeeRepository.findAll());

        return "addProject";
    }

    @GetMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable int id) {

        projectRepository.deleteById(id);

        return "redirect:/projects";
    }
}