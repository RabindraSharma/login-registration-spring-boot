package com.sharma.loginregistration.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.sharma.loginregistration.modal.User;
import com.sharma.loginregistration.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	
	User save(UserRegistrationDto dto);

}
