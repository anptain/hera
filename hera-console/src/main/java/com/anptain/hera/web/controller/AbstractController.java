package com.anptain.hera.web.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.anptain.hera.web.model.WebUser;

public abstract class AbstractController {
	
	protected Long getUserId() {
		WebUser user = this.getUser();
		return user != null ? user.getUserId() : null;
	}

	protected WebUser getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return (WebUser) principal;
		}
		return null;
	}
	
}
