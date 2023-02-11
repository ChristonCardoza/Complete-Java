package com.spring05restapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring05restapi.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
