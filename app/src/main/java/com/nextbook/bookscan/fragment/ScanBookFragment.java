package com.nextbook.bookscan.fragment;

import android.support.v4.app.Fragment;

import com.google.gson.Gson;
import com.nextbook.bookscan.R;
import com.nextbook.bookscan.activity.BookActivity_;
import com.nextbook.bookscan.model.Book;
import com.nextbook.bookscan.rest.BookService;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.rest.spring.annotations.RestService;

@EFragment(R.layout.fragment_scan_book)
public class ScanBookFragment extends Fragment {

    private static final String TAG = ScanBookFragment.class.getSimpleName();

    private Book book;

    @RestService
    BookService bookService;

    @Click
    void scanButton() {
        rest("978-86-7762-754-6");
    }

    @Background
    void rest(String isbn) {
        final Gson gson = new Gson();

        this.book = bookService.getBookByISBN(isbn);
        BookActivity_.intent(this).extra("jsonBook", gson.toJson(this.book)).start();
    }
}
