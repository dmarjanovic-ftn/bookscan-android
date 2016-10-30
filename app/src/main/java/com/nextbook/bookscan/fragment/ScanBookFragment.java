package com.nextbook.bookscan.fragment;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.nextbook.bookscan.R;
import com.nextbook.bookscan.model.Book;
import com.nextbook.bookscan.rest.BookService;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

@EFragment(R.layout.fragment_scan_book)
public class ScanBookFragment extends Fragment {

    private static final String TAG = ScanBookFragment.class.getSimpleName();

    private Book book;

    @RestService
    BookService bookService;

    @ViewById
    TextView bookInfo;

    @Background
    @Click
    void btnScan() {
        final String isbn = "978-86-88003-71-1";

        this.book = bookService.getBookByISBN(isbn);
        // Log.i(TAG, this.book.toString());

        changeUI();

    }

    @UiThread
    void changeUI() {
        bookInfo.setText(book.toString());
    }
}
