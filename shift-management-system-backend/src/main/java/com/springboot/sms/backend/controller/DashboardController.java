package com.springboot.sms.backend.controller;

import com.springboot.sms.backend.entity.Shift;
import com.springboot.sms.backend.entity.User;
import com.springboot.sms.backend.service.ShiftService;
import com.springboot.sms.backend.service.UserService;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
    
    @Autowired
    private ShiftService shiftService;
    
    @Autowired
    private UserService userService;
    
    @GetMapping
    public String showDashboard(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.findByUsername(username);
        
        List<Shift> userShifts = shiftService.getShiftsByUserId(user.getId());
        model.addAttribute("shifts", userShifts);
        model.addAttribute("user", user);
        
        return "dashboard";
    }
}
