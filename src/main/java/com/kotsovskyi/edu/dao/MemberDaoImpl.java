package com.kotsovskyi.edu.dao;

import com.kotsovskyi.edu.entity.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao{
    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void save(Member member) {
        em.merge(member);
    }

    @Override
    @Transactional
    public List<Member> getAll() {
//        String txt = "SELECT member.member_passport, member.email, member.name, member.date_registration" +
//                " FROM Member join role on role.role_id = member.role_id";
        String txt ="Select * from Member";

        Query querry = em.createNativeQuery(txt, Member.class);
        return querry.getResultList();
    }

    @Override
    public Member findByEmail(String email) {
        Query querry = em.createNativeQuery("Select * from Member where email = ?", Member.class);
        querry.setParameter(1, email);

        return (Member) querry.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Member member) {
        em.merge(member);
    }

    @Override
    public Member findByPassport(String passport) {
        Query querry = em.createNativeQuery("SELECT * FROM Member WHERE member_passport = ?", Member.class);
        querry.setParameter(1, passport);

        return (Member) querry.getSingleResult();
    }
}
