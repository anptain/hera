package com.anptain.hera.service;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anptain.hera.domain.User;
import com.anptain.hera.repository.UserRepository;
import com.anptain.hera.service.model.UserInfo;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User register(UserInfo userInfo) {
		User user = new User();
		BeanUtils.copyProperties(userInfo, user);
		return userRepository.save(user);
	}
}