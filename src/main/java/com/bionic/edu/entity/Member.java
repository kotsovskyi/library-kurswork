package com.bionic.edu.entity;

import javax.persistence.*;

@Entity
@Table
public class Member {
    @Id
    @Column(name = "member_passport")
    private String passport;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String password;

    @Column(name = "date_registration")
    private String dateRegistration;

    @ManyToOne
    private Role role;

    public Member() {
    }

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
