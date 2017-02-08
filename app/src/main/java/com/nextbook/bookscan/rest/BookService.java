package com.nextbook.bookscan.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.nextbook.bookscan.model.Book;
import com.nextbook.bookscan.util.Constants;

import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.Rest;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.List;

@Rest(rootUrl = Constants.SERVER_URL, converters = MappingJackson2HttpMessageConverter.class)
public interface BookService {

    @Get("api/books/{isbn}")
    Book getBookByISBN(@Path String isbn);

    @Post("api/ratings/books/{isbn}/mark/{mark}")
    JsonNode rateBook(@Path String isbn, @Path Integer mark);

    @Get("api/books/recommendation")
    List<Book> getRecommendedBooks();

    @Get("api/ratings/books/{isbn}/average")
    Double getAverageRating(@Path String isbn);
}
