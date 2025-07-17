package com.springboot.sms.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }
    
    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }
    
    @PostMapping("/contact")
    public String handleContactForm(@RequestParam String name, 
                                  @RequestParam String email,
                                  @RequestParam String subject,
                                  @RequestParam String message) {
        
        return "redirect:/contact?success";
    }
}