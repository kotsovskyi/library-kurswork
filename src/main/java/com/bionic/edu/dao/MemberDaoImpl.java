package com.bionic.edu.dao;

import com.bionic.edu.entity.Book;
import com.bionic.edu.entity.Member;
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
    public List<Book> getAll() {
        String txt = "SELECT member.member_passport, member.email, member.name, member.date_registration, role.role_name" +
                " FROM Member join role on role.role_id = member.role_id";

        Query querry = em.createNativeQuery(txt, Book.class);
        return querry.getResultList();
    }

    @Override

    public Member findByEmail(String email) {
        Query querry = em.createNativeQuery("Select * from Member  where email = " + email, Book.class);

        return (Member) querry.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Member member) {
        em.merge(member);
    }

    @Override
    public Member findByName(String name) {
        Query querry = em.createNativeQuery("SELECT * FROM Member WHERE name = " + name, Book.class);

        return (Member) querry.getSingleResult();
    }
}
