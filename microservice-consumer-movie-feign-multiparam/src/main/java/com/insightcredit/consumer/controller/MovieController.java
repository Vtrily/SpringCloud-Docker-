package com.insightcredit.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insightcredit.consumer.dao.UserFeignClient;
import com.insightcredit.consumer.pojo.User;

@RestController
public class MovieController {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id){
		return this.userFeignClient.findById(id);
	}
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public User findByIdAndName(@RequestParam("id") Long id,@RequestParam("name") String name){
		return this.userFeignClient.findByIdAndName(id, name);
	}
}
