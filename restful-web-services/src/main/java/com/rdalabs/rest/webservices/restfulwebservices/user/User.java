
package com.rdalabs.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Required;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about the user. ")  // swagger doc
public class User {

	private Integer id;

	@Size(min=2, message="name should have min 2 characters")
	@NotNull(message="name should not be blank")
	private String name;
	
	@Past(message="Birth date should be in the past")
	@NotNull(message="birth date should not be blank")
	@ApiModelProperty(notes="Birth date should be in the past")   // swagger doc
	private Date birthDate;
	
	public User() {}
	
	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}
