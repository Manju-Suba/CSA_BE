package com.csa.cs.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.csa.cs.model.User;

@Service
public interface AuthService{

	ResponseEntity<?> signIn(User user);

	ResponseEntity<?> logout();

}
