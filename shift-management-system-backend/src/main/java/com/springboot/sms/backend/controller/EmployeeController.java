package com.springboot.sms.backend.controller;

import com.springboot.sms.backend.entity.Employee;
import com.springboot.sms.backend.entity.User;
import com.springboot.sms.backend.service.EmployeeService;
import com.springboot.sms.backend.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class EmployeeController {
    
    private final EmployeeService employeeService;
    private final UserService userService;

    public EmployeeController(EmployeeService employeeService, UserService userService) {
        this.employeeService = employeeService;
        this.userService = userService;
    }
    
    @GetMapping("/employees")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }
    
    @GetMapping("/employee/new")
    public String createEmployeeForm(Model model) {
        
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, Principal principal) {
        
        User currentUser = userService.findByUsername(principal.getName());

     
        
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }
    
    @GetMapping("/employee/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "edit_employee";
    }
    
    @PostMapping("/employee/edit/{id}")
    public String updateEmployee(@PathVariable Long id,
            @ModelAttribute("employee") Employee employee, Model model) {
        
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        
        
        employeeService.updateEmployee(existingEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees";
    }
}
