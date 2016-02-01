package com.kotsovskyi.edu.controller;

import com.kotsovskyi.edu.bean.MemberBean;
import com.kotsovskyi.edu.dao.MemberDao;
import com.kotsovskyi.edu.entity.Member;
import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@Scope("session")
public class MemberController {

    @Inject
    private MemberDao memberDao;

    @Inject
    private MemberBean memberBean;

    private Member member;

    private String passport;
    private String email;
    private String name;
    private String dateRegistration;

    private  List<Member> members;

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<Member> getMembers() {
        return members;
    }

    @PostConstruct
    public void init() {
        members = memberDao.getAll();
    }

    public String addMember() {
        Member member = new Member();

        member.setPassport(passport);
        member.setEmail(email);
        member.setName(name);
        member.setDateRegistration("01-02-2016"); // dateRegistration will be automatically inserted
        member.setPassword("ppppp"); // password will be automatically generated

        memberDao.save(member);

        return "successAddMember";
    }

    public void findByPassport(){
        member = memberDao.findByPassport(this.passport);
    }


    public void onBookEdit(RowEditEvent event) {
        Member member = (Member) event.getObject();
        if (memberDao.findByPassport(member.getPassport()) != null) {
            if(memberDao.update(member)){
                FacesMessage msg = new FacesMessage("Читач відредагований",((Member) event.getObject()).getName());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }
        }
    }

    public void onBookCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Редагування відмінено", ((Member) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
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

    public String getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(String dateRegistration) {
        this.dateRegistration = dateRegistration;
    }
}
