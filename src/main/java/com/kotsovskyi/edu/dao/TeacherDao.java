package com.kotsovskyi.edu.dao;

import com.kotsovskyi.edu.entity.Teacher;

import java.util.List;

public interface TeacherDao {

    void save(Teacher teacher);

    List<Teacher> getAll();

    Teacher findById(int id);

    void update(Teacher teacher1);
}
