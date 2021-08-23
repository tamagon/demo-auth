package com.example.demo.auth.service;


import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.auth.model.Role;
import com.example.demo.auth.model.User;
import com.example.demo.auth.repository.RoleRepository;
import com.example.demo.auth.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private RoleRepository roleRepo;
	

	@Override
	public void save(User user) {
		// user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		List<Role> roles = roleRepo.findAll();
		user.setRoles( new HashSet<Role>( roles));
		userRepo.save(user);
		
		
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

}
