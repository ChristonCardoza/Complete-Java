package com.jpa.repositories;

import com.jpa.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findAuthorByFirstNameAndLastName(String firstName, String lastName);
}