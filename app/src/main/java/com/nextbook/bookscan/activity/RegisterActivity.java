package com.nextbook.bookscan.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.nextbook.bookscan.R;
import com.nextbook.bookscan.model.User;
import com.nextbook.bookscan.rest.UserService;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

@EActivity(R.layout.activity_register)
public class RegisterActivity extends AppCompatActivity {

    @RestService
    UserService userService;

    @ViewById
    EditText firstName;

    @ViewById
    EditText lastName;

    @ViewById
    EditText username;

    @ViewById
    EditText password;

    @ViewById
    EditText repeatPassword;

    @ViewById
    TextView errorMessage;

    @Click
    void login() {
        LoginActivity_.intent(this).start();
        finish();
    }

    @Click
    void register() {
        final String message;
        if ((message = validateInput()) == null) {
            User user = new User(firstName.getText().toString(), lastName.getText().toString(), username.getText().toString(), password.getText().toString());
            registerUser(user);
            LoginActivity_.intent(this).start();
        }
        else {
            setMessage(message);
        }
    }

    @Background
    void registerUser(User user) {
        userService.registerUser(user);
    }

    @UiThread
    void setMessage(String message) {
        errorMessage.setText(message);
        errorMessage.setVisibility(View.VISIBLE);
    }

    private String validateInput() {

        if (isEmpty(firstName) || isEmpty(lastName) || isEmpty(username) || isEmpty(password) || isEmpty(repeatPassword)) {
            return "All fields are required!";
        }

        if (username.length() < 6) {
            return "Username must have at least 6 characters";
        }

        if (!password.getText().toString().equals(repeatPassword.getText().toString())) {
            return "Please make sure your passwords match";
        }

        return null;
    }

    private boolean isEmpty(EditText field) {
        return "".equals(field.getText().toString());
    }
}
