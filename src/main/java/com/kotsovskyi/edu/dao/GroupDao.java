package com.kotsovskyi.edu.dao;

import com.kotsovskyi.edu.entity.Groups;

import java.util.List;

public interface GroupDao {

    void save(Groups groups);

    List<Groups> getAll();

    Groups findById(int id);

    void update(Groups groups1);

    Groups findByName(String name);

    List<Groups> getGroupsByStudentId(int id);
}
