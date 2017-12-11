package com.insightcredit.provider.controller;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.insightcredit.provider.entity.User;
import com.insightcredit.provider.repository.UserRepository;


@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails){
			UserDetails user = (UserDetails) principal;
			Collection<? extends GrantedAuthority> collection = user.getAuthorities();
			for(GrantedAuthority c : collection){
				UserController.LOGGER.info("当前用户是{},角色是{}", user.getUsername(),c.getAuthority());
			}
		}else{
			
		}
		User findOne = this.userRepository.findOne(id);
		return findOne;
	}
}
