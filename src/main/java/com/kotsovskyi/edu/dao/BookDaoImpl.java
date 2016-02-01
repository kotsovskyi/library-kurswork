package com.kotsovskyi.edu.dao;

import com.kotsovskyi.edu.entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager em;


    @Override
    @Transactional
    public boolean save(Book book) {
        Query query = em.createNativeQuery("Insert into BOOK (book_id, title, author, published_date, price, " +
                "rack_number) " + "VALUES (?, ?, ?, ?, ?, ?)");

        query.setParameter(1, book.getBookId());
        query.setParameter(2, book.getTitle());
        query.setParameter(3, book.getAuthor());
        query.setParameter(4, book.getPublishedDate());
        query.setParameter(5, book.getPrice());
        query.setParameter(6, book.getRackNumber());

        int updateCount = query.executeUpdate();

        return updateCount == 1;
    }

    @Override
    @Transactional
    public List<Book> getAll() {
        String txt = "SELECT * FROM Book";
        Query querry = em.createNativeQuery(txt, Book.class);
        return querry.getResultList();
    }

    @Override
    public Book findById(Long book_id) {
        Book book = null;
        long id = book_id.longValue();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        Query querry = em.createNativeQuery("Select * from Book where book_id = " + id, Book.class);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        try{
            book = (Book) querry.getSingleResult();
        }
        catch(NoResultException e){
            System.out.println("За даним id = " + id + " не знайдено книжки !!!");
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Знайдено знайдено ООООООООООООО ОООООООО ->>> " + book.getTitle());
        return book;
    }

    @Override
    @Transactional
    public void update(Book book) {
        Query querry = em.createNativeQuery("UPDATE BOOK  SET title = ?, author = ?, published_date = ?," +
                " price = ?, rack_number = ? where book_id = " + book.getBookId());

        querry.setParameter(1, book.getTitle());
        querry.setParameter(2, book.getAuthor());
        querry.setParameter(3, book.getPublishedDate());
        querry.setParameter(4, book.getPrice());
        querry.setParameter(5, book.getRackNumber());

        querry.executeUpdate();
    }

    @Override
    public Book findByTitle(String title) {
        Book book = null;
        Query querry = em.createNativeQuery("SELECT * FROM BOOK WHERE title = " + title, Book.class);
        try{
            book = (Book) querry.getSingleResult();
        }
        catch(NoResultException e){
            System.out.println("За даним title = " + title + " не знайдено книжки !!!");
        }
        return book;
    }
}
