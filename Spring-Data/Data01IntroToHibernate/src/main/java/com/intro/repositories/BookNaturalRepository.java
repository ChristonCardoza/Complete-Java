package com.intro.repositories;

import com.intro.domain.BookNatural;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookNaturalRepository extends JpaRepository<BookNatural, String> {
}
