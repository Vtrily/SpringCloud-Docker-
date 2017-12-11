package com.insightcredit.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.insightcredit.provider.entity.User;
import com.insightcredit.provider.repository.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id){
		User user = this.userRepository.findOne(id);
		return user;
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public User findByIdAndName(Long id,String name){
		User user = this.userRepository.findByIdAndName(id, name);
		return user;
	}
	
	
}
