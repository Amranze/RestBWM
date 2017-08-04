package com.example;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.Entity.UserEntity;
import com.example.Repository.UserRepository;

public class MongoDbFactory {
	static final Logger logger = LoggerFactory.getLogger(MongoDbFactory.class); 
	public static void main( String[] args ) { 
		logger.info("Bootstrapping MongoDemo application"); 
		//URL location = MongoDbFactory.class.getProtectionDomain().getCodeSource().getLocation();
        //System.out.println(location.getFile());
		//ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml"); 
		UserRepository usersrepo = new UserRepository();
		usersrepo.logAllUsers();
		logger.info("Finished MongoDemo application");
	}

}
