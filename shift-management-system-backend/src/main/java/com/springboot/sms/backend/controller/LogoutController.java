package com.springboot.sms.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String logoutPage() {
        
        return "logout";  
    }
    
}
