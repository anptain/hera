package com.anptain.hera.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class SysPropertie extends AbstractEntity {
	private static final long serialVersionUID = -5527156169360964308L;
	private String key;
	private String value;
	private String description;
	@Enumerated(EnumType.STRING)
	private PropStatus status;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public PropStatus getStatus() {
		return status;
	}

	public void setStatus(PropStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public enum PropStatus {
		/** 禁用 */
		DISABLE,
		/** 启用 */
		ENABLED
	}
}
