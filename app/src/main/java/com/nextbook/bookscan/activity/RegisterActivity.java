package com.nextbook.bookscan.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nextbook.bookscan.R;
import com.nextbook.bookscan.model.User;
import com.nextbook.bookscan.rest.UserService;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

@EActivity(R.layout.activity_register)
public class RegisterActivity extends AppCompatActivity {

    @RestService
    UserService userService;

    @ViewById
    TextView firstName;

    @ViewById
    TextView lastName;

    @ViewById
    TextView username;

    @ViewById
    TextView password;

    @Click
    void login() {
        LoginActivity_.intent(this).start();
        finish();
    }

    @Click
    void register() {
        final String fn = firstName.getText().toString();
        final String ln = lastName.getText().toString();
        final String un = username.getText().toString();
        final String pw = password.getText().toString();

        User user = new User(fn, ln, un, pw);
        registerUser(user);
    }

    @Background
    void registerUser(User user) {
        userService.registerUser(user);
    }
}
