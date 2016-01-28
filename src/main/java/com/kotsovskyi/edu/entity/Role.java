package com.kotsovskyi.edu.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Role {
    @Id
    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy="role")
    private List<Member> members;

    public Role() {
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Member> getListOfMembers() {
        return members;
    }

    public void setListOfMembers(List<Member> listOfMembers) {
        this.members = listOfMembers;
    }
}
