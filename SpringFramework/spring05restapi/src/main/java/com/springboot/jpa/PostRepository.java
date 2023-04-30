package com.springboot.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
