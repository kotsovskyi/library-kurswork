package com.bionic.edu.controller;

import com.bionic.edu.bean.BookBean;
import com.bionic.edu.dao.BookDao;
import com.bionic.edu.entity.Book;
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
    private BookDao bookDao;

    @Inject
    private BookBean bookBean;

    public List<Book> getBooks() {
        return bookDao.getAll();
    }

    @Transactional
    public String addBook() {
        Book book = new Book(bookBean);
        bookDao.save(book);
        return "success";
    }

    @Transactional
    public void onBookEdit(RowEditEvent event) {
        Book book = (Book) event.getObject();

        System.out.println("ID = " + book.getBookId());
        System.out.println("titleNEW = " + ((Book) event.getObject()).getTitle());
        System.out.println("author = " + book.getAuthor());
        System.out.println("date = " + book.getPublishedDate());
        System.out.println("price = " + book.getPrice());
        System.out.println("Rack = " + book.getRackNumber());

        if (bookDao.findById(book.getBookId()) != null) {
            System.out.println("ЗНАЙДЕНО ");
            System.out.println("ЗНАЙДЕНО ");
            System.out.println("ЗНАЙДЕНО ");
            bookDao.update(book);

            System.out.println("ОНОВЛЕНО");
            System.out.println("ОНОВЛЕНО");
            System.out.println("ОНОВЛЕНО");

        }
        FacesMessage msg = new FacesMessage("Книжка відредагована", Long.toString(((Book) event.getObject()).getBookId()) );
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onBookCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Редагування відмінено", Long.toString(((Book) event.getObject()).getBookId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
