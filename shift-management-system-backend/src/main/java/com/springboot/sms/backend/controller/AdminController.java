package com.springboot.sms.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/admin/home")
    public String adminDashboard(Model model, Authentication authentication) {
        
        model.addAttribute("username", authentication.getName());
        model.addAttribute("roles", authentication.getAuthorities());
        return "admin/home";
    }
}