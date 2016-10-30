package com.nextbook.bookscan.rest;

import com.nextbook.bookscan.model.Book;
import com.nextbook.bookscan.util.Constants;

import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Rest(rootUrl = Constants.SERVER_URL, converters = MappingJackson2HttpMessageConverter.class)
public interface BookService {

    @Get("/book/{isbn}")
    Book getBookByISBN(@Path String isbn);
}
