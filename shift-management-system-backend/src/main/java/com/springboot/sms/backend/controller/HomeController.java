package com.springboot.sms.backend.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
    public String homePage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsername = authentication.getName();
        model.addAttribute("username", currentUsername); 
        return "home";
    }
	
    @GetMapping("/home")
    public String home(Model model, Authentication authentication) {
        String username = authentication.getName(); 
        model.addAttribute("username", username);
        return "home"; 
    }
}
