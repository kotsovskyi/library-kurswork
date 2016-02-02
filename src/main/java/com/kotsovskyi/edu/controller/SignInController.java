package com.kotsovskyi.edu.controller;

import com.kotsovskyi.edu.dao.MemberDao;
import com.kotsovskyi.edu.entity.Member;
import org.springframework.context.annotation.Scope;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named
@Scope("session")
public class SignInController {
    @Inject
    private MemberDao memberDao;

    private String login = null;
    private String pass = null;
    private Member member;

    public Member getMember(){
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    public void findMember(){
        member = memberDao.findByLoginPassword(login, pass);

        if(member != null) {
            if(member.getRole().getRoleName().equals("librarian")) {
                System.out.println("ADMIN !!!");
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("adminPage.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("memberPage.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            showMessage();
        }
    }

    public void backToLogInPage() {
        setMember(null);
        setLogin(null);
        setPass(null);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMessage() {

        FacesContext.getCurrentInstance().addMessage("lala:namek", new FacesMessage("Помилка! неправильний логін чи пароль"));
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
