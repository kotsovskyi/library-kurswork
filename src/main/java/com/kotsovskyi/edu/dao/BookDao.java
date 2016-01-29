package com.kotsovskyi.edu.dao;

import com.kotsovskyi.edu.entity.Book;

import java.util.List;

public interface BookDao {
    void save(Book book);

    List getAll();

    Book findById(Long book_id);

    void update(Book Book);

    Book findByTitle(String title);
}