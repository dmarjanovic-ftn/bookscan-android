package com.nextbook.bookscan.activity;

import android.support.annotation.UiThread;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

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

    @ViewById
    Button login;

    @ViewById
    ProgressBar loginProgressBar;

    @Click
    void login() {
        showProgressBar();
        MainActivity_.intent(this).start();
        finish();
    }

    @UiThread
    void showProgressBar() {
        loginProgressBar.setVisibility(View.VISIBLE);
        login.setVisibility(View.INVISIBLE);
    }
}
