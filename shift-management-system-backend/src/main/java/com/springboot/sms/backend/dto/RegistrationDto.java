package com.springboot.sms.backend.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private String username;
    private String password;
    
	public String getUsername() {
		return username;
	}
	public CharSequence getPassword() {
		return password;
	}
}
