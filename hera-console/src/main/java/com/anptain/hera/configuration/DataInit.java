package com.anptain.hera.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anptain.hera.constants.Constants;
import com.anptain.hera.domain.SysProperty;
import com.anptain.hera.domain.User;
import com.anptain.hera.repository.SysPropertyRepository;
import com.anptain.hera.repository.UserRepository;

@Service
public class DataInit {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private SysPropertyRepository sysPropertyRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostConstruct
	public void dataInit() {
		User admin = new User();
		admin.setPassword(passwordEncoder.encode("admin"));
		admin.setUsername("admin");
		userRepository.save(admin);

		SysProperty staticResourceVersion = new SysProperty();
		staticResourceVersion.setValue("1.0.0");
		staticResourceVersion.setKey(Constants.SP_STATIC_RESOURCE_VERSION);
		staticResourceVersion.setDescription("静态资源版本");
		sysPropertyRepository.save(staticResourceVersion);
		
	}
}
