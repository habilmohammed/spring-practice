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
import com.rdalabs.database.databasedemo.jpa.PersonJpaRepository;

//@SpringBootApplication
public class DatabaseJpaDemoApplication implements CommandLineRunner{

	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseJpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		LOGGER.info("user 10001 -> {}",dao.findById(10001));
		LOGGER.info("insert a row -> {}", dao.insert(new Person("row 2", "location 2", new Date())));
		LOGGER.info("insert a row -> {}", dao.insert(new Person("row 3", "location 3", new Date())));
		LOGGER.info("update 1st row -> {}", dao.update(new Person(10001,"row 1", "location 1", new Date())));
		dao.deleteById(10001);
		LOGGER.info("All users -> {}", dao.findAll());
	}
}