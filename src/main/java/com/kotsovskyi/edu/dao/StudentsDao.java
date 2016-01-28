package com.kotsovskyi.edu.dao;

import com.kotsovskyi.edu.entity.Students;

import java.util.List;

public interface StudentsDao {

    void save(Students students);

    Students findByLogin(String login);

    List<Students> getAll();

    Students findById(int id);

    void update(Students user1);
}
