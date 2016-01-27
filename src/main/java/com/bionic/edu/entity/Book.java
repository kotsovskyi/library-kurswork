package com.bionic.edu.entity;

import com.bionic.edu.bean.BookBean;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table
public class Book {

    @Id
    @Column(name = "book_id")
    private long bookId;

    @Column
    private String title;

    @Column
    private String author;

    @Column(name = "published_date")
    private String publishedDate;

    @Column
    private double price;

    @Column(name = "rack_number")
    private String rackNumber;

    public Book() {
    }

    public Book(BookBean bookBean) {
        this.bookId = bookBean.getBook_id();
        this.title = bookBean.getTitle();
        this.author = bookBean.getAuthor();
        this.publishedDate = bookBean.getPublishingYear();
        this.price = bookBean.getPrice();
        this.rackNumber = bookBean.getRack_number();
    }

    public String getPublishedDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yy-mm-dd");
        Date date = null;
        try {
            date = formatter.parse(publishedDate);
            System.out.println("yesss");
        } catch (ParseException e) {
            System.out.println("nooo");
            e.printStackTrace();
        }
        return formatter.format(date);
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(String rackNumber) {
        this.rackNumber = rackNumber;
    }
}
