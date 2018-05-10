package com.habilmohammed.spring.basics.componentscan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.habilmohammed.spring.basics.springin5steps.scope.JdbcConnection;

@Component
public class ComponentPersonDao {

	@Autowired
	ComponentJdbcConnection jdbcConnection;

	public ComponentJdbcConnection getJdbcConnection() {
		return jdbcConnection;
	}

	public void setJdbcConnection(ComponentJdbcConnection jdbcConnection) {
		this.jdbcConnection = jdbcConnection;
	}
	
}
