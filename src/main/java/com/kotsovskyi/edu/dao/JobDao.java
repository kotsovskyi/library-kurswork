package com.kotsovskyi.edu.dao;

import com.kotsovskyi.edu.entity.Job;

import java.util.List;

public interface JobDao {

    void save(Job job);

    List<Job> getAll();

    Job findById(int id);

    void update(Job job1);

    List<Job> getStudentJobsById(int id);
}
