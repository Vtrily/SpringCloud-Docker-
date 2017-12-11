package com.insightcredit.provider.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.insightcredit.provider.entity.SecurityUser;

@Component
public class CustomUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if("user".equals(username)){
			return new SecurityUser("user","password1","user-role");
		}else if("admin".equals(username)){
			return new SecurityUser("admin","password2","admin-role");
		}
		return null;
	}

}
