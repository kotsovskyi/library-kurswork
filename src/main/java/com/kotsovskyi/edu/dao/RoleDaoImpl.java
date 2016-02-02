package com.kotsovskyi.edu.dao;

import com.kotsovskyi.edu.entity.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public void save(Role role) {
        Query query = em.createNativeQuery("Insert into Role (role_id, role_name) " + "VALUES (?, ?)");

        query.setParameter(1, "book_seq.nextval");
        query.setParameter(2, role.getRoleName());

        query.executeUpdate();
    }

    @Override
    @Transactional
    public List<Role> getAll() {
        String txt = "SELECT * FROM Role";
        Query querry = em.createNativeQuery(txt, Role.class);
        return querry.getResultList();
    }

    @Override
    public Role findById(int role_id) {
        Role role = null;
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Query querry = em.createNativeQuery("Select * from Role where role_id = " + role_id, Role.class);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        try{
            role = (Role) querry.getSingleResult();
        }
        catch(NoResultException e){
            System.out.println("За даним id = " + role_id + " не знайдено книжки !!!");
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Знайдено знайдено ООООООООООООО ОООООООО ->>> " + role.getRoleName());
        return role;
    }

    @Override
    @Transactional
    public void update(Role role) {
//        Query querry = em.createNativeQuery("UPDATE BOOK  SET title = ?, author = ?, published_date = ?," +
//                " price = ?, rack_number = ? where book_id = " + book.getBookId());
//
//        querry.setParameter(1, book.getTitle());
//        querry.setParameter(2, book.getAuthor());
//        querry.setParameter(3, book.getPublishedDate());
//        querry.setParameter(4, book.getPrice());
//        querry.setParameter(5, book.getRackNumber());

//        querry.executeUpdate();
        em.merge(role);
    }

    @Override
    public Role findByName(String name) {
        Role role = null;
        Query querry = em.createNativeQuery("SELECT * FROM BOOK WHERE title = " + name, Role.class);
        try{
            role = (Role) querry.getSingleResult();
        }
        catch(NoResultException e){
            System.out.println("За даним name = " + name + " не знайдено ролі !!!");
        }
        return role;
    }
}
