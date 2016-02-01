package com.kotsovskyi.edu.controller;

import com.kotsovskyi.edu.bean.BookBean;
import com.kotsovskyi.edu.dao.BookDao;
import com.kotsovskyi.edu.entity.Book;
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

    private Book book;

    private Long bookId;
    private String title;
    private String author;
    private String publishedDate;
    private Double price;
    private String rackNumber;

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
        Book book = new Book();

        book.setBookId(bookId);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishedDate(publishedDate);
        book.setPrice(price);
        book.setRackNumber(rackNumber);

        bookDao.save(book);

        return "successAddBook";
    }

    public void findById(Long book_id){
        System.out.println("++++++++++++++++++++++++++++++++++++++++ " + book_id);
        book = bookDao.findById(book_id);
        System.out.println("?????????????????????? " + book.getBookId());
        //return "bookFined";
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

    public BookBean getBookBean(){
        return this.bookBean;
    }

    public void setBookBean(BookBean bookBean) {
        this.bookBean = bookBean;
    }

    public Book getBook() {
        try {
            return this.book;
        } finally {
//            book = null;
//            bookId = null;
        }
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(String rackNumber) {
        this.rackNumber = rackNumber;
    }
}
