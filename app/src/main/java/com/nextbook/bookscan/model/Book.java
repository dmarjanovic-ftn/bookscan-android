package com.nextbook.bookscan.model;

import java.io.Serializable;

public class Book implements Serializable {

    private String title;
    private String author;
    private String language;
    private String year;
    private String publisher;

    public Book() {
        super();
    }

    public Book(String title, String author, String language, String year, String publisher) {
        this.title = title;
        this.author = author;
        this.language = language;
        this.year = year;
        this.publisher = publisher;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", year='" + year + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
