package com.intro.repositories;

import com.intro.domain.composite.AuthorComposite;
import com.intro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}