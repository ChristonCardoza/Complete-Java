package com.spring05restapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring05restapi.user.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
