package com.springboot.sms.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springboot.sms.backend.service.ShiftService;
import com.springboot.sms.backend.service.UserService;

@Controller
@RequestMapping("/admin/shifts")
public class AdminShiftController {
	
	@Autowired
    private ShiftService shiftService;
    
    @Autowired
    private UserService userService;
   
    @GetMapping
    public String showAllShifts(Model model) {
        model.addAttribute("shifts", shiftService.getAllShifts());
        model.addAttribute("users", userService.getAllUsers());
        return "admin/shifts";
    }

    // Assign the shift to the user
    @PostMapping("/assign")
    public String assignShiftToUser(
            @RequestParam Long shiftId,
            @RequestParam Long userId,
            RedirectAttributes redirectAttributes) {
        
        shiftService.assignShiftToUser(shiftId, userId);
        redirectAttributes.addFlashAttribute("success", "Shift assigned successfully");
        return "redirect:/admin/shifts";
    }
}
    
