package com.springboot.sms.backend.controller;

import com.springboot.sms.backend.entity.Shift;
import com.springboot.sms.backend.entity.User;
import com.springboot.sms.backend.repository.UserRepository;
import com.springboot.sms.backend.service.ShiftService;
import com.springboot.sms.backend.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class ShiftController {

    private final ShiftService shiftService;
    private final UserRepository userRepository;
    private final UserService userService;

    public ShiftController(ShiftService shiftService, UserRepository userRepository, UserService userService) {
        this.shiftService = shiftService;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    
    @GetMapping("/shifts")
    public String listShifts(Model model) {
        List<Shift> shifts = shiftService.getAllShifts();
        model.addAttribute("shifts", shifts);
        return "shifts";  
    }

    
    @GetMapping("/shift/new")
    public String createShiftForm(Model model) {
        Shift shift = new Shift();
        List<User> users = userRepository.findAll();
        model.addAttribute("shift", shift);
        model.addAttribute("users", users); 
        return "create_shift"; 
    }

    
    @PostMapping("/shifts")
    public String saveShift(@ModelAttribute("shift") Shift shift, 
                           BindingResult result,
                           Principal principal) {
        
       
        User currentUser = userService.findByUsername(principal.getName());
        shift.setUser(currentUser);
        
        shiftService.saveShift(shift);
        return "redirect:/shifts";
    }

    
    @GetMapping("/shift/edit/{id}")
    public String editShiftForm(@PathVariable("id") Long id, Model model) {
        Shift shift = shiftService.getShiftById(id);
        List<User> users = userRepository.findAll();
        model.addAttribute("shift", shift);
        model.addAttribute("users", users);
        return "edit_shift"; 
    }

    
    @PostMapping("/shift/edit/{id}")
    public String updateShift(@PathVariable Long id, @ModelAttribute("shift") Shift shift, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("users", userRepository.findAll());
            return "edit_shift"; 
        }

        Shift existingShift = shiftService.getShiftById(id);
        existingShift.setShiftName(shift.getShiftName());
        existingShift.setShiftStart(shift.getShiftStart());
        existingShift.setShiftEnd(shift.getShiftEnd());


        shiftService.updateShift(existingShift);
        return "redirect:/shifts"; 
    }

    
    @GetMapping("/shift/delete/{id}")
    public String deleteShift(@PathVariable Long id) {
        shiftService.deleteShiftById(id);
        return "redirect:/shifts"; 
    }
    
    @PostMapping("/assign-shift")
    public String assignShift(@RequestParam Long userId, @ModelAttribute Shift shift) {
        User user = userService.findById(userId);
        shift.setUser(user);
        shiftService.save(shift);
        return "redirect:/shifts";
    }

}
