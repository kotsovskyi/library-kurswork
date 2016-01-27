package com.bionic.edu.bean;

import javax.inject.Named;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Named
public class BookBean {

    private long book_id;
    private String title;
    private String author;
    private String publishedDate;
    private double price;
    private String rack_number;

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishingYear() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(publishedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatter.format(date);
    }

    public void setPublishingYear(String publishingYear) {
        System.out.println("DATE ->> " + publishingYear);
        this.publishedDate = publishingYear;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRack_number() {
        return rack_number;
    }

    public void setRack_number(String rack_number) {
        this.rack_number = rack_number;
    }
}
