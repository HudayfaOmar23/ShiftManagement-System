package com.springboot.sms.backend.serviceimpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.springboot.sms.backend.entity.Shift;
import com.springboot.sms.backend.entity.User;
import com.springboot.sms.backend.repository.ShiftRepository;
import com.springboot.sms.backend.repository.UserRepository;
import com.springboot.sms.backend.service.ShiftService;

import org.springframework.transaction.annotation.Transactional;


@Service
public class ShiftServiceImpl implements ShiftService {

    @Autowired
    private ShiftRepository shiftRepository; 
    
    @Autowired
    private UserRepository userRepository; 
    
    @Override
    public List<Shift> getShiftsByUserId(Long userId) {
        return shiftRepository.findByUserId(userId);
    }

    @Override
    @Transactional
    public Shift saveShift(Shift shift) {
        if (shift.getUser() == null || shift.getUser().getId() == null) {
            throw new IllegalArgumentException("Shift must be assigned to a user");
        }
        
        User user = userRepository.findById(shift.getUser().getId())
            .orElseThrow(() -> new RuntimeException("User not found with ID: " + shift.getUser().getId()));
        
        Shift savedShift = shiftRepository.save(shift);
        user.addShift(savedShift);
        return savedShift;
    }

    @Override
    public Shift getShiftById(Long id) {
        
        Optional<Shift> shift = shiftRepository.findById(id);
        if (shift.isPresent()) {
            return shift.get();
        } else {
            throw new RuntimeException("Shift not found with ID: " + id);
        }
    }

    @Override
    public Shift updateShift(Shift shift) {
        
        if (shiftRepository.existsById(shift.getId())) {
            return shiftRepository.save(shift);
        } else {
            throw new RuntimeException("Shift not found with ID: " + shift.getId());
        }
    }

    @Override
    public void deleteShiftById(Long id) {
        
        if (shiftRepository.existsById(id)) {
            shiftRepository.deleteById(id);
        } else {
            throw new RuntimeException("Shift not found with ID: " + id);
        }
    }
    
    @Override
    public Shift save(Shift shift) {
        return shiftRepository.save(shift);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Shift> getAllShifts() {
            return shiftRepository.findAll();  
    }

    @Override
    @Transactional
    public void assignShiftToUser(Long shiftId, Long userId) {
        Shift shift = shiftRepository.findById(shiftId)
            .orElseThrow(() -> new RuntimeException("Shift not found"));
        
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));
        
        shift.setUser(user);
        shiftRepository.save(shift);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.ASC, "username"));
    }

}
