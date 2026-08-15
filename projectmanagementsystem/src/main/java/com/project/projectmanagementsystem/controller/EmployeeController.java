package com.project.projectmanagementsystem.controller;

import com.project.projectmanagementsystem.entity.Employee;
import com.project.projectmanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/addEmployee")
    public String showForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        employeeRepository.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employees")
    public String viewEmployees(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employeeList";
    }

    @GetMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable int id, Model model) {

        Employee employee = employeeRepository.findById(id).orElse(null);

        model.addAttribute("employee", employee);

        return "addEmployee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id) {

        employeeRepository.deleteById(id);

        return "redirect:/employees";
    }
}