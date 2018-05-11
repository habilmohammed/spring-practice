package com.rdalabs.database.databasedemo.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="person")	// Not neccessary as names match
@NamedQuery(name="find_all_persons",  query="select p from Person p")  // Person is referencing the entity.
public class Person {
	
	@Id					// To denote the primary key
	@GeneratedValue		// To auto generate the id, creates some kind of sequence
	private Integer id;
	
	@Column(name="name") // Not neccessary as names match
	private String name;
	
	@Column(name="location")  // Not neccessary as names match
	private String location;
	
	@Column(name="birth_date")  // Not neccessary as names match
	private Date birthDate;
	
	public Person() {}
	
	public Person(Integer id, String name, String location, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}
	
	public Person(String name, String location, Date birthDate) {
		super();
		this.name = name;
		this.location = location;
		this.birthDate = birthDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", location=" + location + ", birthDate=" + birthDate + "]";
	}
	
}
