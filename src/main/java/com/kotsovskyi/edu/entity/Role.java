package com.kotsovskyi.edu.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Role {
    @Id
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "role")
    private List<Member> members;


    public Role() {
        members = new ArrayList<Member>();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member){
        if (!getMembers().contains(member)) {
            getMembers().add(member);
            if (member.getRole() != null) {
                member.getRole().getMembers().remove(member);
            }
            member.setRole(this);
        }
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
