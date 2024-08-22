package com.csa.cs.serviceImplementation;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.csa.cs.jwt.JwtUtils;
import com.csa.cs.model.User;
import com.csa.cs.repository.UserRepo;
import com.csa.cs.response.ApiResponse;
import com.csa.cs.service.AuthService;
import com.csa.cs.service.security.UserDetailsImpl;

@Service
public class AuthServiceImplementation implements AuthService {

        private final AuthenticationManager authenticationManager;
        private final JwtUtils jwtUtils;

        @Autowired
        public AuthServiceImplementation(
                        AuthenticationManager authenticationManager,
                        UserRepo userRepository,
                        PasswordEncoder encoder,
                        JwtUtils jwtUtils) {
                this.authenticationManager = authenticationManager;
                this.jwtUtils = jwtUtils;
        }

        @Override
        public ResponseEntity<?> signIn(User user) {
                Authentication authentication = authenticationManager
                                .authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(),
                                                user.getPassword()));

                SecurityContextHolder.getContext().setAuthentication(authentication);
                UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
                String jwt = jwtUtils.generateTokenFromUsername(userDetails.getEmail());
                ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(jwt);
          
//                Map<String, Object> userData = Map.of();
                
                Map<String, Object> userData = Map.of(
                	    "Token", jwt,
                	    "name", userDetails.getName(),
                	    "emp_id", userDetails.getEmp_id(),
                	    "email", userDetails.getEmail(),
                	    "role", userDetails.getRole(),
                	    "dept", userDetails.getDept()  // Corrected key to "dept"
                	);

                	ApiResponse response = new ApiResponse(true, "Login Successfully", userData);

                return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString()).body(response);
        }
        
        public ResponseEntity<?> logout() {
    		ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
    		ApiResponse response = new ApiResponse(true, "User has been logged out!", "");
    		return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
    				.body(response);
    	}

}