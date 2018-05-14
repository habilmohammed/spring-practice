package com.rdalabs.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {
	
	String msg;

	public HelloWorldBean(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [msg=" + msg + "]";
	}
	
}
