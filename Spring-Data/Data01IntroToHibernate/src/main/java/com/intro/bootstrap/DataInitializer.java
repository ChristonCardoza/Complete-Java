package com.intro.bootstrap;

import com.intro.domain.Book;
import com.intro.domain.Author;
import com.intro.domain.AuthorUuid;
import com.intro.domain.BookUuid;
import com.intro.repositories.AuthorRepository;
import com.intro.repositories.AuthorUuidRepository;
import com.intro.repositories.BookRepository;
import com.intro.repositories.BookUuidRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AuthorUuidRepository authorUuidRepository;
    private final BookUuidRepository bookUuidRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, AuthorUuidRepository authorUuidRepository, BookUuidRepository bookUuidRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.authorUuidRepository = authorUuidRepository;
        this.bookUuidRepository = bookUuidRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();
        authorUuidRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse", null);
        Book savedDDD = bookRepository.save(bookDDD);

        Book bookSIA = new Book("Spring In Action", "234234", "Oriely", null);
        Book savedSIA = bookRepository.save(bookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });

        Author author = new Author();
        author.setFirstName("Joe");
        author.setLastName("Buck");
        authorRepository.save(author);

        AuthorUuid authorUuid = new AuthorUuid();
        authorUuid.setFirstName("Joe");
        authorUuid.setLastName("Buck");
        AuthorUuid savedAuthor = authorUuidRepository.save(authorUuid);
        System.out.println("Saved Author UUID: " + savedAuthor.getId() );

        BookUuid bookUuid = new BookUuid();
        bookUuid.setTitle("All About UUIDs");
        BookUuid savedBookUuid = bookUuidRepository.save(bookUuid);
        System.out.println("Saved Book UUID: " + savedBookUuid.getId());
    }
}