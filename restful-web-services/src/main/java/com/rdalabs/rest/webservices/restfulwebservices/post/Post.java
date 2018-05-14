/**
 * 
 */
package com.rdalabs.rest.webservices.restfulwebservices.post;

/**
 * @author Habil Mohammed
 *
 */
public class Post {
	
	private Integer postId;

	private Integer userId;
	
	private String body;
	
	public Post() {}

	public Post(Integer postId, Integer userId, String body) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.body = body;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", body=" + body + "]";
	}

}
