package com.nextbook.bookscan.model;

import java.io.Serializable;

public class Book implements Serializable {

    private String isbn;
    private String title;
    private String authors;
    private String language;
    private Integer year;
    private String publisher;
    private String genre;
    private String collection;
    private String physicalDescription;
    private String imageUrl;

    public Book() {
        super();
    }

    public Book(String isbn, String title, String authors, String language, Integer year, String publisher, String genre, String collection, String physicalDescription, String imageUrl) {
        this.isbn = isbn;
        this.title = title;
        this.authors = authors;
        this.language = language;
        this.year = year;
        this.publisher = publisher;
        this.genre = genre;
        this.collection = collection;
        this.physicalDescription = physicalDescription;
        this.imageUrl = imageUrl;
    }

    public Book(String title, String authors, String language, Integer year, String publisher) {
        this.title = title;
        this.authors = authors;
        this.language = language;
        this.year = year;
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getPhysicalDescription() {
        return physicalDescription;
    }

    public void setPhysicalDescription(String physicalDescription) {
        this.physicalDescription = physicalDescription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
