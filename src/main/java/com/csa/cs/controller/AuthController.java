package com.csa.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csa.cs.exception.ValidationException;
import com.csa.cs.model.User;
import com.csa.cs.service.AuthService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@GetMapping("/get-user")
	public String getUser() {
		return "Hi";
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		if (user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
			throw new ValidationException("Username and Password should not be empty");
		}
		return authService.signIn(user);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<?> logoutUser() {
		return authService.logout();
	}

}
