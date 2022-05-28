package com.sharma.loginregistration.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	@GetMapping("/features")
	public String features() {
		return "features";
	}
	@GetMapping("/services")
	public String services() {
		return "services";
	}
}
