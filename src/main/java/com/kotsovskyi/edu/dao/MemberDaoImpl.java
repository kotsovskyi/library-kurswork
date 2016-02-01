package com.kotsovskyi.edu.dao;

import com.kotsovskyi.edu.bean.BookBean;
import com.kotsovskyi.edu.entity.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao{
    @PersistenceContext
    private EntityManager em;
    private BookBean bookBean;

    @Override
    @Transactional
    public boolean save(Member member) {
        Query query = em.createNativeQuery("Insert into Member (member_passport, email, name, password, date_registration, role_id) " +
                "Values (?,?,?,?,?,?)");
        query.setParameter(1, member.getPassport());
        query.setParameter(2, member.getEmail());
        query.setParameter(3, member.getName());
        query.setParameter(4, member.getPassword());
        query.setParameter(5, member.getDateRegistration());
        query.setParameter(6, 1L); // mean that member's role is 'user'

        int updateCount = query.executeUpdate();

        return updateCount == 1;
    }

    @Override
    public List<Member> getAll() {
        Query querry = em.createNativeQuery("Select * from Member", Member.class);
        List<Member> members = null;

        try {
            members = querry.getResultList();
        } catch (NoResultException e){
            e.printStackTrace();
        }

        if(members != null){
            return members;
        }

        return null;
    }

    @Override
    public Member findByLoginPassword(String email, String password) {
        Query querry = this.em.createNativeQuery("Select * FROM Member m JOIN ROLE r ON m.role_id = r.role_id WHERE email = ? AND password = ?", "MemberRoleMapping");
        querry.setParameter(1, email);
        querry.setParameter(2, password);
        Member member = null;
        System.out.println("find by loginPassword");
        try {
            Object[] result = (Object[])querry.getSingleResult();
            member = (Member) result[0];
        } catch(NoResultException e){
            System.out.println("Увага! Користувача з таким логіном та паролем не існує");
        }

        if(member != null && member.getPassword().equals(password) && member.getEmail().equals(email)){
            return member;
        }

        return null;
    }

    @Override
    public Member findByEmail(String email) {
        String txt = "Select * from Member where email = " + email;
        TypedQuery<Member> querry = em.createQuery(txt, Member.class);
        Member member = null;
        try{
            member = querry.getSingleResult();
        }
        catch(NoResultException e){
        }
        if(member != null && member.getEmail().equals(email) ){
            return member;
        }
        return null;
    }

    @Override
    @Transactional
    public boolean update(Member member) {
        Query querry = em.createNativeQuery("UPDATE Member SET email = ?, name = ? WHERE member_passport = ?");
        querry.setParameter(1, member.getEmail());
        querry.setParameter(2, member.getName());
        querry.setParameter(3, member.getPassport());

        int updateCount = querry.executeUpdate();

        em.getEntityManagerFactory().getCache().evictAll();

        //        em.refresh(member);

        return updateCount == 1;
    }

    @Override
    public Member findByPassport(String passport) {
        Query querry = em.createNativeQuery("SELECT * FROM Member WHERE member_passport = ?", Member.class);
        querry.setParameter(1, passport);
        Member member = null;

        try {
            member = (Member) querry.getSingleResult();
        } catch (NoResultException e){
            e.printStackTrace();
        }

        if(member != null && member.getPassport().equals(passport) ){
            return member;
        }

        return null;
    }

    public BookBean getBookBean() {
        return bookBean;
    }

    public void setBookBean(BookBean bookBean) {
        this.bookBean = bookBean;
    }
}
