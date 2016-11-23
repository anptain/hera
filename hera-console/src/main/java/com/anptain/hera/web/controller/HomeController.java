package com.anptain.hera.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anptain.hera.exception.BadCaptchaException;

@Controller
public class HomeController extends AbstractController{
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(String error, Model model, HttpSession session) {
		Object expcetion = session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (error != null && expcetion != null) {
			if (expcetion instanceof BadCredentialsException) {
				model.addAttribute("loginMsg", "用户名或密码错误");
			}
			if (expcetion instanceof BadCaptchaException) {
				model.addAttribute("loginMsg", "验证码输入错误");
			}
		}
		return "login";
	}
}
