package com.sharma.loginregistration.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sharma.loginregistration.modal.Role;
import com.sharma.loginregistration.modal.User;
import com.sharma.loginregistration.repository.UserRepository;
import com.sharma.loginregistration.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl  implements UserService{

	private UserRepository repository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public User save(UserRegistrationDto dto) {
		User user = new User(
				dto.getFirstName(),
				dto.getLastName(), 
				dto.getEmail(), 
				passwordEncoder.encode(dto.getPassword()), 
				Arrays.asList(new Role("ROLE_USER")));
		return repository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException("invalid username and password");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	

}
