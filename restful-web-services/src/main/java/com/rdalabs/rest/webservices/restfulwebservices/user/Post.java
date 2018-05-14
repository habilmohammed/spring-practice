/**
 * 
 */
package com.rdalabs.rest.webservices.restfulwebservices.user;

/**
 * @author Habil Mohammed
 *
 */
public class Post {

	private Integer postId;
	
	private String body;
	
	public Post() {}

	public Post(Integer postId, String body) {
		super();
		this.postId = postId;
		this.body = body;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", body=" + body + "]";
	}
	
	
}
