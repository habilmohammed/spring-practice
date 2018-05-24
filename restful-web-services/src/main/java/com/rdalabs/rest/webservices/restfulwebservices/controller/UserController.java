/**
 * 
 */
package com.rdalabs.rest.webservices.restfulwebservices.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rdalabs.rest.webservices.restfulwebservices.exception.PostNotFoundException;
import com.rdalabs.rest.webservices.restfulwebservices.post.Post;
import com.rdalabs.rest.webservices.restfulwebservices.post.PostDaoService;
import com.rdalabs.rest.webservices.restfulwebservices.user.User;
import com.rdalabs.rest.webservices.restfulwebservices.user.UserDaoService;
import com.rdalabs.rest.webservices.restfulwebservices.user.UserNotFoundException;

/**
 * @author Habil Mohammed
 *
 */

@RestController
public class UserController {

	@Autowired
	UserDaoService userService;
	
	@Autowired
	PostDaoService postService;
	
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
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
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
	
	@RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
	public User deleteUserById(@PathVariable int id) {
		User user = userService.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("id -> "+id);
		}
		return user;
	}
		
	@RequestMapping(method=RequestMethod.GET, value="/users/{userid}/posts")
	public List<Post> getAllPostsOfUser(@PathVariable int userid) {
		return postService.findPostsByUserId(userid);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/users/{userid}/posts/{postid}")
	public Post getPostByPostId(@PathVariable int userid, @PathVariable int postid) {
		Post post = postService.findPostByUserIdAndPostId(userid, postid);
		if (post !=null) {
			return post;
		} else {
			throw new PostNotFoundException("postid ->" + postid); 
		}
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users/{userid}/posts")
	public ResponseEntity<Object> addPostForUser(@RequestBody Post post, @PathVariable int userid) {
		User user = userService.findOne(userid);
		if (user == null) {
			throw new UserNotFoundException("id -> "+userid);
		} 
		Post savedPost = postService.savePost(post);
		if (savedPost!=null) {
			URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{postid}")
			.buildAndExpand(savedPost.getPostId())
			.toUri();
			
			return ResponseEntity.created(location).build();
		}
		return null;
	}

}