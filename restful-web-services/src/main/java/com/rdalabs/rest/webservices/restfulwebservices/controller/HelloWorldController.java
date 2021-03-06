package com.rdalabs.rest.webservices.restfulwebservices.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rdalabs.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@RequestMapping(method=RequestMethod.GET , value="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello world bean");
	}

	@RequestMapping(method=RequestMethod.GET , value="/hello-world/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean("hello world, "+ name);
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/hello-world-intl")
	public String helloWorldInternationalized() {
		return "Good Morning";
	}

}
