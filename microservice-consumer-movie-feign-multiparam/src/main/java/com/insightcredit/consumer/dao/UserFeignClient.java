package com.insightcredit.consumer.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.insightcredit.consumer.pojo.User;

@FeignClient(name = "user-provider")
public interface UserFeignClient {
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public User findByIdAndName(@RequestParam("id") Long id,@RequestParam("name") String name);
}
