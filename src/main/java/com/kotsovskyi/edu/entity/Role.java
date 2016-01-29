package com.kotsovskyi.edu.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Role {
    @Id
    private int roleId;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(targetEntity = Member.class)
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

    public List<Member> getListOfMembers() {
        return members;
    }

    public void setListOfMembers(List<Member> listOfMembers) {
        this.members = listOfMembers;
    }

    public void addMembers(Member member){
        if (!getListOfMembers().contains(member)) {
            getListOfMembers().add(member);
            if (member.getRole() != null) {
                member.getRole().getListOfMembers().remove(member);
            }
            member.setRole(this);
        }
    }
}
