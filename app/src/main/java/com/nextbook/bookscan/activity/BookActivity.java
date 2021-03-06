package com.nextbook.bookscan.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nextbook.bookscan.R;
import com.nextbook.bookscan.model.Book;
import com.nextbook.bookscan.rest.BookService;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

@EActivity(R.layout.activity_book)
public class BookActivity extends AppCompatActivity {

    @RestService
    BookService bookService;

    @ViewById
    Toolbar toolbar;

    @ViewById
    TextView bookTitle;

    @ViewById
    TextView bookAuthors;

    @ViewById
    TextView bookLanguage;

    @ViewById
    TextView bookYear;

    @ViewById
    TextView bookRate;

    @Extra
    String jsonBook;

    private Book book;

    @AfterExtras
    void getBookData() {
        final Gson gson = new Gson();
        this.book = gson.fromJson(jsonBook, Book.class);
    }

    @AfterViews
    void setToolbar() {
        setSupportActionBar(toolbar);
    }

    @AfterViews
    void updateDataUI() {
        bookTitle.setText(this.book.getTitle());
        bookAuthors.setText(this.book.getAuthors());
        bookLanguage.setText(this.book.getLanguage());
        bookYear.setText(String.valueOf(this.book.getYear()));
    }

    @AfterInject
    void afterInject() {
        getRating();
    }

    @Background
    void getRating() {
        final Double rating = bookService.getAverageRating(book.getIsbn());
        updateRating(rating);
    }

    @UiThread
    void updateRating(Double rating) {
        bookRate.setText(String.valueOf(rating));
    }

    @Click({R.id.rate1, R.id.rate2, R.id.rate3, R.id.rate4, R.id.rate5})
    void rateBook(TextView view) {
        final Integer rate = getClickedRate(view);

        performRating(book.getIsbn(), rate);
    }

    @Background
    void performRating(String isbn, Integer mark) {
        bookService.rateBook(isbn, mark);
        getRating();
        changeStarColors(mark);
    }

    @UiThread
    void changeStarColors(Integer number) {
        for (int i = 1; i <= number; ++i) {
            TextView view = (TextView) findViewById(getItemId(i));
            view.setTextColor(getResources().getColorStateList(R.color.colorRatingGold));
        }

        for (int i = number + 1; i <= 5; ++i) {
            TextView view = (TextView) findViewById(getItemId(i));
            view.setTextColor(getResources().getColorStateList(R.color.colorRatingGray));
        }
    }

    private Integer getClickedRate(TextView view) {
        switch (view.getId()) {
            case R.id.rate1:
                return 1;
            case R.id.rate2:
                return 2;
            case R.id.rate3:
                return 3;
            case R.id.rate4:
                return 4;
            case R.id.rate5:
                return 5;
            default:
                return 0;
        }
    }

    private int getItemId(Integer number) {
        switch (number) {
            case 1:
                return R.id.rate1;
            case 2:
                return R.id.rate2;
            case 3:
                return R.id.rate3;
            case 4:
                return R.id.rate4;
            case 5:
                return R.id.rate5;
        }

        return -1;
    }

}
