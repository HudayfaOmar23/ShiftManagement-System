package com.springboot.sms.backend.controller;

import com.springboot.sms.backend.entity.Role;
import com.springboot.sms.backend.entity.User;
import com.springboot.sms.backend.repository.RoleRepository;
import com.springboot.sms.backend.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; 
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            model.addAttribute("error", "Passwords do not match.");
            return "register";
        }

        
        if (userRepository.findByUsername(user.getUsername())!= null) {
            model.addAttribute("error", "Username already taken.");
            return "register";
            
        }
        
      
        Role defaultRole = roleRepository.findByName("ROLE_USER")
        	    .orElseThrow(() -> new RuntimeException("Default role not found"));

        	user.setRoles(List.of(defaultRole));
        

        
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        
        System.out.println("Roles: " + user.getRoles());


        
        userRepository.save(user);

        return "redirect:/login"; 
    }
}
