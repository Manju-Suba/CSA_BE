package com.csa.cs.model;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(length = 50)
	private String email;
	private String password;
	private String role;
	private String dept;
	@Column(length = 50)
	private String empId;
	@Column(length = 50)
	private boolean status;
	private LocalDateTime createddate;
	
	

}
