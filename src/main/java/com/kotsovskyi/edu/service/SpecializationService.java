package com.kotsovskyi.edu.service;

import com.kotsovskyi.edu.entity.Specialization;

import java.util.List;

public interface SpecializationService {

    void save(Specialization specialization);

    List<Specialization> getAll();

    Specialization findById(int n);

    void update(Specialization specialization1);
}
