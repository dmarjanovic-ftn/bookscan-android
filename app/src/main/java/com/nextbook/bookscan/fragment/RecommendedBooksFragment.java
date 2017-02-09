package com.nextbook.bookscan.fragment;

import android.support.v4.app.Fragment;
import android.widget.ListView;

import com.google.gson.Gson;
import com.nextbook.bookscan.R;
import com.nextbook.bookscan.activity.BookActivity_;
import com.nextbook.bookscan.adapter.RecommendedBooksListAdapter;
import com.nextbook.bookscan.model.Book;
import com.nextbook.bookscan.rest.BookService;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.androidannotations.rest.spring.annotations.RestService;

import java.util.List;

@EFragment(R.layout.fragment_my_books)
public class RecommendedBooksFragment extends Fragment {

    private List<Book> books;

    @RestService
    BookService bookService;

    @ViewById
    ListView recommendedBooks;

    @Bean
    RecommendedBooksListAdapter adapter;

    @AfterViews
    void getData() {
        getRecommended();
    }

    @Background
    void getRecommended() {
        this.books = bookService.getRecommendedBooks();
        updateList();
    }

    @UiThread
    void updateList() {
        adapter.books = books;
        recommendedBooks.setAdapter(adapter);
    }

    @ItemClick
    void recommendedBooksItemClicked(Book book) {
        final Gson gson = new Gson();
        BookActivity_.intent(this).extra("jsonBook", gson.toJson(book)).start();
    }

}
