package com.kotsovskyi.edu.dao;

import com.kotsovskyi.edu.entity.Member;

import java.util.List;

public interface MemberDao {
    boolean save(Member member);

    List getAll();

    Member findByEmail(String email);

    boolean update(Member member);

    Member findByPassport(String passport);

    Member findByLoginPassword(String email, String password);
}
