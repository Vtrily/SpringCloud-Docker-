package com.insightcredit.provider.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insightcredit.provider.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	//public List<User> findByName(String name);
	
	//@Query("select id, username, name, age, balance from user where id = ?1 and username = ?1")
	public User findByIdAndName(Long id, String name);
}
