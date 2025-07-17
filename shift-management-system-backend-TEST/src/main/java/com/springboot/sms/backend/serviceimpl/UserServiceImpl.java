package com.springboot.sms.backend.serviceimpl;

import com.springboot.sms.backend.config.UserNotFoundException;
import com.springboot.sms.backend.entity.Role;
import com.springboot.sms.backend.entity.User;
import com.springboot.sms.backend.repository.RoleRepository;
import com.springboot.sms.backend.repository.UserRepository;
import com.springboot.sms.backend.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User user) {
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        
        Role defaultRole = roleRepository.findByName("ROLE_USER")
            .orElseThrow(() -> new RuntimeException("Default role not found"));

        
        user.setRoles(List.of(defaultRole));

        
        return userRepository.save(user);
    }

    @Override
    public User getUserDetails(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + id));
    }
    
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
