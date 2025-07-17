package com.springboot.sms.backend.service;

import java.util.List;

import com.springboot.sms.backend.entity.User;

public interface UserService {
    User registerUser(User user);
    User getUserDetails(String username);
    User findByUsername(String username);
	User findById(Long userId);
	List<User> getAllUsers();
}

