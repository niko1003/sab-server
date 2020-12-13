package org.sab.bsm.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private final List<String> roles;

	public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
		token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public String getEmail() {
		return email;
	}

	public Long getId() {
		return id;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getTokenType() {
		return type;
	}

	public String getUsername() {
		return username;
	}

	public void setAccessToken(String accessToken) {
		token = accessToken;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTokenType(String tokenType) {
		type = tokenType;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}