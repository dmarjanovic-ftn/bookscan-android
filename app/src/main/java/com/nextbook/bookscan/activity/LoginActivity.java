package com.nextbook.bookscan.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nextbook.bookscan.R;
import com.nextbook.bookscan.model.ResponseToken;
import com.nextbook.bookscan.rest.ErrorHandler;
import com.nextbook.bookscan.rest.UserService;
import com.nextbook.bookscan.util.AuthToken;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.TextChange;
import org.androidannotations.annotations.UiThread;
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

    @ViewById
    TextView message;

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

    @TextChange({R.id.username, R.id.password})
    void hideMessage() {
        message.setVisibility(View.GONE);
    }

    @Click
    void login() {
        showProgressBar();
        message.setVisibility(View.GONE);
        auth(username.getText().toString(), password.getText().toString());
    }

    @Click
    void register() {
        RegisterActivity_.intent(this).start();
        finish();
    }

    @Background
    void auth(String username, String password) {
        ResponseToken response = userService.auth(new UserAuth(username, password));
        if (response != null) {
            AuthToken.token = response.getToken();
            MainActivity_.intent(this).start();
            finish();
        }
        else {
            hideProgressBar();
            showWrongLoginMessage();
        }
    }

    @UiThread
    void showProgressBar() {
        loginProgressBar.setVisibility(View.VISIBLE);
        login.setVisibility(View.INVISIBLE);
    }

    @UiThread
    void hideProgressBar() {
        loginProgressBar.setVisibility(View.INVISIBLE);
        login.setVisibility(View.VISIBLE);
    }

    @UiThread
    void showWrongLoginMessage() {
        password.setText("");
        message.setVisibility(View.VISIBLE);
    }

    public class UserAuth {
        private String email;
        private String password;

        public UserAuth() {
            super();
        }

        public UserAuth(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
