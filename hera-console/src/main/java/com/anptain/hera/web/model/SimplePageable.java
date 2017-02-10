package com.anptain.hera.web.model;

import org.springframework.data.domain.PageRequest;

public class SimplePageable extends PageRequest {

	private static final long serialVersionUID = 60244327696953959L;

	public SimplePageable(int page, int size) {
		super(page, size);
	}

	public static SimplePageable defaultPage(Integer page, Integer size) {
		if (page == null) {
			page = 1;
		}
		if (size == null) {
			size = 10;
		}
		return new SimplePageable(page, size);
	}
}
