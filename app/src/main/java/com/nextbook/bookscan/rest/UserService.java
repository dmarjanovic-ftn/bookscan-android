package com.nextbook.bookscan.rest;

import com.nextbook.bookscan.model.ResponseToken;
import com.nextbook.bookscan.model.User;
import com.nextbook.bookscan.util.Constants;

import org.androidannotations.rest.spring.annotations.Body;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.Post;
import org.androidannotations.rest.spring.annotations.Rest;
import org.androidannotations.rest.spring.api.RestClientErrorHandling;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Rest(rootUrl = Constants.SERVER_URL, converters = MappingJackson2HttpMessageConverter.class, interceptors = AuthInterceptor.class)
public interface UserService extends RestClientErrorHandling {

    @Post("api/users")
    void registerUser(@Body User user);

    @Post("api/users/auth?username={username}&password={password}")
    ResponseToken auth(@Path String username, @Path String password);

    @Get("/user/logged")
    User getLoggedUser();
}
