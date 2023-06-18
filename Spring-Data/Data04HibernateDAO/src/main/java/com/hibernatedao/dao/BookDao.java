package com.hibernatedao.dao;

import com.hibernatedao.domain.Book;

import java.util.List;

public interface BookDao {
    Book findByISBN(String isbn);

    Book getById(Long id);

    Book findBookByTitle(String title);

    Book findBookByTitleCriteria(String clean_code);

    Book saveNewBook(Book book);

    Book updateBook(Book book);

    void deleteBookById(Long id);

    List<Book> findAll();

    Book findBookByTitleNative(String title);

}