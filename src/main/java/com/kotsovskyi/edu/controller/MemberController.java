package com.kotsovskyi.edu.controller;

import com.kotsovskyi.edu.bean.MemberBean;
import com.kotsovskyi.edu.dao.MemberDao;
import com.kotsovskyi.edu.entity.Member;
import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public String addMember() {
        Member member = new Member(memberBean);
        memberDao.save(member);
        return "success";
    }

    public void findByPassport(String passport){
        member = memberDao.findByPassport(passport);
    }


    @Transactional
    public void onBookEdit(RowEditEvent event) {
        Member member = (Member) event.getObject();
        System.out.println("1-> " + member.getName());
        System.out.println("2-> " + member.getDateRegistration());
        System.out.println("3-> " + member.getEmail());
        System.out.println("4-> " + member.getPassport());
        System.out.println("5-> " + member.getRole());

        if (memberDao.findByEmail(member.getEmail()) != null) {
            System.out.println("1-> " + member.getName());
            System.out.println("2-> " + member.getDateRegistration());
            System.out.println("3-> " + member.getEmail());
            System.out.println("4-> " + member.getPassport());
            System.out.println("5-> " + member.getRole());
            memberDao.update(member);
        }
        FacesMessage msg = new FacesMessage("Читач відредагований",((Member) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
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
}
