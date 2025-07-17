package com.springboot.sms.backend.config;

import com.springboot.sms.backend.entity.Role;
import com.springboot.sms.backend.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        if (!roleRepository.existsByName("ROLE_USER")) {
            Role roleUser = new Role();
            roleUser.setName("ROLE_USER");
            roleRepository.save(roleUser);
        }

        if (!roleRepository.existsByName("ROLE_ADMIN")) {
            Role roleAdmin = new Role();
            roleAdmin.setName("ROLE_ADMIN");
            roleRepository.save(roleAdmin);
        }
    }
}
