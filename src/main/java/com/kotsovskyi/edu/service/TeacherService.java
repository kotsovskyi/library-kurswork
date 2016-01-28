package com.kotsovskyi.edu.service;

import com.kotsovskyi.edu.entity.Teacher;

import java.util.List;

public interface TeacherService {

    void save(Teacher teacher);

    List<Teacher> getAll();

    Teacher findById(int n);

    void update(Teacher teacher1);
}
