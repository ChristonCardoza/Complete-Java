package com.intro.repositories;

import com.intro.domain.composite.AuthorEmbedded;
import com.intro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}