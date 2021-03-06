package com.anptain.hera.configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.anptain.hera.domain.User;
import com.anptain.hera.repository.UserRepository;
import com.anptain.hera.web.model.WebUser;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

@Configuration
public class BeanConfiguration {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer(FreeMarkerProperties properties) {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		configurer.setTemplateLoaderPaths(properties.getTemplateLoaderPath());
		configurer.setPreferFileSystemAccess(properties.isPreferFileSystemAccess());
		configurer.setDefaultEncoding(properties.getCharsetName());
		Properties settings = new Properties();
		settings.putAll(properties.getSettings());
		configurer.setFreemarkerSettings(settings);

		Map<String, Object> variables = new HashMap<>();
		configurer.setFreemarkerVariables(variables);
		return configurer;
	}

	@Bean
	public DefaultKaptcha defaultKaptcha() {
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		Properties prop = new Properties();
		// prop.put("kaptcha.border", "no");
		// prop.put("kaptcha.border", "no");
		// prop.put("kaptcha.border.color", "105,179,90");
		// prop.put("kaptcha.textproducer.font.color", "red");
		// prop.put("kaptcha.image.width", "250");
		// prop.put("kaptcha.textproducer.font.size", "80");
		// prop.put("kaptcha.image.height", "90");
		// prop.put("kaptcha.session.key", "code");
		// prop.put("kaptcha.textproducer.char.length", "4");
		// prop.put("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
		defaultKaptcha.setConfig(new Config(prop));
		return defaultKaptcha;
	}

	@Bean
	public UserDetailsService userDetailsService(final UserRepository userRepository) {
		return new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				User user = userRepository.findByUsername(username);
				if (user == null) {
					throw new UsernameNotFoundException("");
				}
				// authorities.add(new
				// SimpleGrantedAuthority(user.getRole().name()));
				return new WebUser(user.getId(), user.getUsername(), user.getPassword(), new ArrayList<GrantedAuthority>());
			}
		};
	}
}
