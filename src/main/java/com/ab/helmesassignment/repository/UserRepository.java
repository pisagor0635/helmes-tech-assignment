package com.ab.helmesassignment.repository;

import com.ab.helmesassignment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
