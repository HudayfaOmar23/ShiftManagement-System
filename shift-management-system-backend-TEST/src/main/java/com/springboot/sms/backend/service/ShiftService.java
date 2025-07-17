package com.springboot.sms.backend.service;

import java.util.List;
import com.springboot.sms.backend.entity.Shift;
import com.springboot.sms.backend.entity.User;

public interface ShiftService {
    
    List<Shift> getAllShifts(); 
    
    Shift saveShift(Shift shift); 
    
    Shift getShiftById(Long id); 
    
    Shift updateShift(Shift shift); 
    
    void deleteShiftById(Long id); 
    Shift save(Shift shift);
    
    List<Shift> getShiftsByUserId(Long userId);
    
    void assignShiftToUser(Long shiftId, Long userId);
    
    List<User> getAllUsers();
}

