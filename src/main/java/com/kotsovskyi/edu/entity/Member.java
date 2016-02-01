package com.kotsovskyi.edu.entity;

import com.kotsovskyi.edu.bean.MemberBean;

import javax.persistence.*;

@Entity
@SqlResultSetMapping(
        name = "MemberRoleMapping",
        entities = {
                @EntityResult(
                        entityClass = Member.class,
                        fields = {
                                @FieldResult(name = "passport", column = "member_passport"),
                                @FieldResult(name = "email", column = "email"),
                                @FieldResult(name = "name", column = "name"),
                                @FieldResult(name = "password", column = "password"),
                                @FieldResult(name = "dateRegistration", column = "date_registration"),
                                @FieldResult(name = "role", column = "role_id")}),
                @EntityResult(
                        entityClass = Role.class,
                        fields = {
                                @FieldResult(name = "Role.roleId", column = "role_id"),
                                @FieldResult(name = "Role.roleName", column = "role_name")})}
)
public class Member {
    @Id
    @Column(name = "member_passport")
    private String passport;
    private String email;
    private String name;
    private String password;

    @Column(name = "date_registration")
    private String dateRegistration;

    @ManyToOne
    private Role role;

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(String dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
