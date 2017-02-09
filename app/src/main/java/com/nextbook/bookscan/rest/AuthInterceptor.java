package com.nextbook.bookscan.rest;

import android.util.Log;

import com.nextbook.bookscan.util.AuthToken;

import org.androidannotations.annotations.EBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@EBean(scope = EBean.Scope.Singleton)
public class AuthInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpHeaders headers = request.getHeaders();
        headers.set("X-AUTH-TOKEN", AuthToken.token);
        if (AuthToken.token != null)
        Log.d("TAG", AuthToken.token.toString());
        return execution.execute(request, body);
    }
}
