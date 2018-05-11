package com.rdalabs.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rdalabs.database.databasedemo.entity.Person;
import com.rdalabs.database.databasedemo.jdbc.PersonJdbcDao;

//@SpringBootApplication
public class DatabaseJdbcDemoApplication implements CommandLineRunner{

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
/*		
 		LOGGER.info("arg0 -> {}", args[0]);
		LOGGER.info("arg1 -> {}", args[1]);
		LOGGER.info("arg2 -> {}", args[2]);
*/
		LOGGER.info("All persons -> {}",dao.findAll());
		LOGGER.info("user id 10001 -> {}", dao.findById(10001));
		LOGGER.info("delete id 10002 -> {}", dao.deleteById(10002));
		LOGGER.info("insert a new record -> {}", 
				dao.insert(new Person(10004, "record four", "hyderbad", new Date())));
		LOGGER.info("update 10003 -> {}", 
				dao.update(new Person(10003, "Peter", "Atlantis", new Date())));	
	}
}
