package com.kotsovskyi.edu.service;


import com.kotsovskyi.edu.entity.Lesson;

import java.util.List;

public interface LessonService {

    void save(Lesson lesson);

    List<Lesson> getAll();

    Lesson findById(int n);

    void update(Lesson lesson1);

    List<Lesson> getStudentLessons(int id);
}
