package com.anptain.hera.configuration;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.anptain.hera.domain.SysProperty;
import com.anptain.hera.domain.User;
import com.anptain.hera.repository.UserRepository;


@Service
public class DataInit {
	@Autowired 
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
    @PostConstruct
    public void dataInit(){
        User admin = new User();
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setUsername("admin");
        userRepository.save(admin);
        
        SysProperty staticResourceVersion = new SysProperty();
        staticResourceVersion.setValue("1.0.0");
        
        
    }
}
