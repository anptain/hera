package com.anptain.hera.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Authority extends AbstractEntity {

	private static final long serialVersionUID = -1416138670307566210L;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	private String role;
	private String remark;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
