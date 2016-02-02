package com.kotsovskyi.edu.dao;


import com.kotsovskyi.edu.entity.Role;

import java.util.List;

public interface RoleDao {
    void save(Role role);

    List getAll();

    Role findById(int roleId);

    void update(Role role);

    Role findByName(String roleName);
}
