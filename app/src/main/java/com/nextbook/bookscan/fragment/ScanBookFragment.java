package com.nextbook.bookscan.fragment;

import android.content.Intent;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.nextbook.bookscan.R;
import com.nextbook.bookscan.activity.BookActivity_;
import com.nextbook.bookscan.model.Book;
import com.nextbook.bookscan.rest.BookService;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

@EFragment(R.layout.fragment_scan_book)
public class ScanBookFragment extends Fragment {

    private static final String TAG = ScanBookFragment.class.getSimpleName();

    private Book book;

    @RestService
    BookService bookService;

    @ViewById
    ProgressBar scanProgressBar;

    @ViewById
    Button scanButton;

    @Click
    void scanButton() {
        IntentIntegrator.forSupportFragment(this).initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                // FIXME On Scanning Cancel
                hideProgressBar();
            }
            else {
                rest(result.getContents());
                showProgressBar();
            }
        }
        else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Background
    void rest(String isbn) {
        final Gson gson = new Gson();

        this.book = bookService.getBookByISBN(isbn);

        BookActivity_.intent(this).extra("jsonBook", gson.toJson(this.book)).start();
    }

    @UiThread
    void showProgressBar() {
        scanButton.setVisibility(View.GONE);
        scanProgressBar.setVisibility(View.VISIBLE);
    }

    @UiThread
    void hideProgressBar() {
        scanButton.setVisibility(View.VISIBLE);
        scanProgressBar.setVisibility(View.GONE);
    }
}
