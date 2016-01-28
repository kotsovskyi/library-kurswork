package com.kotsovskyi.edu.dao;

import com.kotsovskyi.edu.entity.Specialization;

import java.util.List;

public interface SpecializationDao {

    void save(Specialization specialization);

    List<Specialization> getAll();

    Specialization findById(int id);

    void update(Specialization specialization1);
}
