package com.bionic.edu.dao;

import com.bionic.edu.entity.Book;

import java.util.List;

public interface BookDao {
    void save(Book book);

    List getAll();

    Book findById(long book_id);

    void update(Book Book);

    Book findByTitle(String title);
}