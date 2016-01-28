package com.kotsovskyi.edu.controller;

import com.kotsovskyi.edu.bean.MemberBean;
import com.kotsovskyi.edu.dao.MemberDao;
import com.kotsovskyi.edu.entity.Member;
import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

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

    public List<Member> getMembers() {
        return memberDao.getAll();
    }

    @Transactional
    public String addMember() {
        Member member = new Member(memberBean);
        memberDao.save(member);
        return "success";
    }

    @Transactional
    public void onBookEdit(RowEditEvent event) {
        Member member = (Member) event.getObject();

        if (memberDao.findByEmail(member.getEmail()) != null) {
            memberDao.update(member);
        }
        FacesMessage msg = new FacesMessage("Читач відредагований",((Member) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onBookCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Редагування відмінено", ((Member) event.getObject()).getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
