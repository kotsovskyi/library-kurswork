package com.kotsovskyi.edu.controller;

import com.kotsovskyi.edu.bean.BookBean;
import com.kotsovskyi.edu.dao.BookDao;
import com.kotsovskyi.edu.entity.Book;
import org.primefaces.event.CellEditEvent;
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
public class BookController {

    @Inject
    private BookDao bookDao;

    @Inject
    private BookBean bookBean;

    private  List<Book> books;

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    @PostConstruct
    public void init() {
        books = bookDao.getAll();
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

        if (bookDao.findById(book.getBookId()) != null) {
            bookDao.update(book);
        }
        FacesMessage msg = new FacesMessage("Книжка відредагована", Long.toString(((Book) event.getObject()).getBookId()) );
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onBookCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Редагування відмінено", Long.toString(((Book) event.getObject()).getBookId()));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
