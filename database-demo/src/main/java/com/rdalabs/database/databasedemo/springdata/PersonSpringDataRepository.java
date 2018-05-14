package com.rdalabs.database.databasedemo.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rdalabs.database.databasedemo.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer> {
	
}
