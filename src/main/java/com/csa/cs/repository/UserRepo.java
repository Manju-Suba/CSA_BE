package com.csa.cs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csa.cs.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

}
