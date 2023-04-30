package com.springboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
