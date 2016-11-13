package com.nextbook.bookscan.activity;

import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.nextbook.bookscan.R;
import com.nextbook.bookscan.model.ResponseToken;
import com.nextbook.bookscan.rest.ErrorHandler;
import com.nextbook.bookscan.rest.UserService;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @RestService
    UserService userService;

    @ViewById
    EditText username;

    @ViewById
    EditText password;

    @ViewById
    Button login;

    @ViewById
    ProgressBar loginProgressBar;

    @Bean
    ErrorHandler errorHandler;

    @AfterInject
    void setErrorHandler() {
        userService.setRestErrorHandler(errorHandler);
    }

    @AfterViews
    void setDefaults() {
        username.setText("sramos");
        password.setText("realmadrid");
    }

    @Click
    void login() {
        showProgressBar();

        auth(username.getText().toString(), password.getText().toString());

        MainActivity_.intent(this).start();
        finish();
    }

    @Click
    void register() {
        RegisterActivity_.intent(this).start();
        finish();
    }

    @Background
    void auth(String username, String password) {
        ResponseToken response = userService.auth(username, password);
        if (response != null) {
            Log.i("JEBEM TI ISUSA", response.getToken());
        }
    }

    @UiThread
    void showProgressBar() {
        loginProgressBar.setVisibility(View.VISIBLE);
        login.setVisibility(View.INVISIBLE);
    }
}
