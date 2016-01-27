package com.bionic.edu.dao;

import com.bionic.edu.entity.Member;

import java.util.List;

public interface MemberDao {
    void save(Member member);

    List getAll();

    Member findByEmail(String email);

    void update(Member member);

    Member findByName(String name);
}
