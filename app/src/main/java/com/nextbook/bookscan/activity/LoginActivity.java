package com.nextbook.bookscan.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.nextbook.bookscan.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @ViewById
    EditText username;

    @ViewById
    EditText password;

    @Click
    void login() {
        MainActivity_.intent(this).start();
        finish();
    }
}
