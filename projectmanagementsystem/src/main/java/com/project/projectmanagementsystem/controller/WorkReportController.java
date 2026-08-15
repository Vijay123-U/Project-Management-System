package com.project.projectmanagementsystem.controller;

import com.project.projectmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkReportController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/workReport")
    public String workReport(Model model) {

        model.addAttribute("tasks", taskRepository.findAll());

        return "workReport";
    }
}