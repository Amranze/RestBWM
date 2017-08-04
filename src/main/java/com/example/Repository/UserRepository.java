package com.example.Repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.example.Entity.UserEntity;

//@Repository
public class UserRepository {
	static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
	
	//@Autowired
	MongoTemplate mongoTemplate;
	
	public void logAllUsers(){
		List<UserEntity> users = mongoTemplate.findAll(UserEntity.class);
		logger.info("Total of users is {} ", users.size());
		logger.info("Users : {}", users);
	}
	
	public void saveSacleModel(){
		
		
	}
}
