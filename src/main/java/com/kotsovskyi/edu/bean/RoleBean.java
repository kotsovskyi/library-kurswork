package com.kotsovskyi.edu.bean;

import com.kotsovskyi.edu.entity.Member;

import javax.inject.Named;
import java.util.List;

@Named
public class RoleBean {

    private String roleName;
    private List<Member> members;


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
