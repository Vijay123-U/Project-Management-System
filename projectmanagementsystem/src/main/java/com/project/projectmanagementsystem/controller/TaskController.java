package com.project.projectmanagementsystem.controller;

import com.project.projectmanagementsystem.entity.Task;
import com.project.projectmanagementsystem.repository.ProjectRepository;
import com.project.projectmanagementsystem.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/addTask")
    public String showTaskForm(Model model) {

        model.addAttribute("task", new Task());

        model.addAttribute("projects", projectRepository.findAll());

        return "addTask";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute Task task) {

        taskRepository.save(task);

        return "redirect:/tasks";
    }

    @GetMapping("/tasks")
    public String viewTasks(Model model) {

        model.addAttribute("tasks", taskRepository.findAll());

        return "taskList";
    }

    @GetMapping("/editTask/{id}")
    public String editTask(@PathVariable int id, Model model) {

        Task task = taskRepository.findById(id).orElse(null);

        model.addAttribute("task", task);

        model.addAttribute("projects", projectRepository.findAll());

        return "addTask";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable int id) {

        taskRepository.deleteById(id);

        return "redirect:/tasks";
    }
}