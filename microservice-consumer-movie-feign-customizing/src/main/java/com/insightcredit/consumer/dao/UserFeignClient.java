package com.insightcredit.consumer.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;

import com.insightcredit.consumer.config.FeignConfiguration;
import com.insightcredit.consumer.pojo.User;

import feign.RequestLine;

@FeignClient(name = "user-provider", configuration = FeignConfiguration.class)
public interface UserFeignClient {
	
	@RequestLine("GET /{id}")
	public User findById(@PathVariable("id") Long id);
}
