package com.FinalStoreDatabase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FinalStoreDatabase.dao.UserRepository;
import com.FinalStoreDatabase.entity.User;
import com.FinalStoreDatabase.service.MySQLUserDetailsService;

@Controller
public class HomeController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MySQLUserDetailsService userService;

	@PostMapping("/register")
	public String createUser(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		User foundUser = userRepository.findByUsername(username);
		if (foundUser == null) {
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);
			userService.Save(newUser);
			return "login";
		} else {
			model.addAttribute("exists", true);
			return "register";
		}
	}

	@GetMapping("/")
	public String getHomePage() {
		return "login";
	}

	@GetMapping("/login")
	public String getLoginPage() {
		return "login";
	}

	@GetMapping("/register")
	public String getRegisterPage() {
		return "register";
	}

}
