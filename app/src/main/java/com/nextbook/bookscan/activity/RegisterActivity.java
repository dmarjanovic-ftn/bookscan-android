package com.nextbook.bookscan.activity;

import android.support.v7.app.AppCompatActivity;

import com.nextbook.bookscan.R;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_register)
public class RegisterActivity extends AppCompatActivity {

    @Click
    void login() {
        LoginActivity_.intent(this).start();
        finish();
    }
}
