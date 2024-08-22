package com.csa.cs.service.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.csa.cs.model.User;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;
    
    private Long id;   
    private String email;  
    private String name;  
    private String emp_id;  
    private String dept;    
    @JsonIgnore
    private String role;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long id, String email, String name, String emp_id, String dept, String role,
			String password, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.setId(id);
		this.setEmail(email);
		this.setName(name);
		this.setEmp_id(emp_id);
		this.setDept(dept);
		this.setRole(role);
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetails build(User user) {
		List<GrantedAuthority> authorities = Arrays.stream(user.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    	return new UserDetailsImpl(
    	        user.getId(), 
    	        user.getEmail(),
    	        user.getName(),
    	        user.getEmpId(),
    	        user.getDept(),
    	        user.getRole(),
    	        user.getPassword(),authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean equals(Object o) {    
        return true;
	}

}