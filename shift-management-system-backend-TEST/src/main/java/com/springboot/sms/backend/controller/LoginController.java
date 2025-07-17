package com.springboot.sms.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	 public String loginPage() {
       System.out.println("Accessing /login");
       return "login";
	}
}