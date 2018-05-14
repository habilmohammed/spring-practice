/**
 * 
 */
package com.rdalabs.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author Habil Mohammed
 *
 */
@RestController
public class UserController {

	@Autowired
	UserDaoService userService;
	
	@RequestMapping(method=RequestMethod.GET, value="/users")
	public List<User> retreiveAllUsers() {
		return userService.findAll();
	} 
	
	@RequestMapping(method=RequestMethod.GET, value="/users/{id}")
	public User retreiveUser(@PathVariable int id) {
		User user = userService.findOne(id);
		if (user == null) {
			throw new UserNotFoundException("id -> "+id);
		}
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public ResponseEntity<Object> addUser(@RequestBody User user) {
		User savedUser = userService.save(user);
		if (savedUser != null) {
			URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId())
			.toUri();
			
			return ResponseEntity.created(location).build();
		}
		return null;
	}

}