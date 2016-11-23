package com.anptain.hera.web.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class WebUser extends org.springframework.security.core.userdetails.User {
	private static final long serialVersionUID = -4591798819031403408L;
	private Long userId;

	public WebUser(Long userId, String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}
}
