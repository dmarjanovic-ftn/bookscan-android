package com.nextbook.bookscan.activity;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.nextbook.bookscan.R;
import com.nextbook.bookscan.adapter.BookListAdapter;
import com.nextbook.bookscan.model.Book;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_book)
public class BookActivity extends AppCompatActivity {

    @Bean
    BookListAdapter adapter;

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
    RecyclerView recommendedBooks;

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
    void bindAdapter() {
        // TODO
        // recommendedBooks
        List<Book> books = new ArrayList<>();
        books.add(new Book("Na Drini cuprija", "Ivo Andric", "srpski", "2008", "Laguna"));
        books.add(new Book("Darkly dreaming Dexter", "Jeff Lindsay", "srpski", "2008", "Vulkan"));
        books.add(new Book("Dearly Devoted Dexter", "Jeff Lindsay", "srpski", "2008", "Hehe"));
        books.add(new Book("Dexter in the Dark", "Jeff Lindsay", "srpski", "2008", "Vulkan"));
        books.add(new Book("Double Dexter", "Jeff Lindsay", "srpski", "2008", "Laguna"));
        books.add(new Book("Dexter is Dead", "Jeff Lindsay", "srpski", "2008", "Laguna"));
        books.add(new Book("Dexter's Final Cut", "Jeff Lindsay", "srpski", "2008", "Hehe"));

        adapter.setItems(books);
        recommendedBooks.setAdapter(adapter);
    }

    @AfterViews
    void updateDataUI() {
        bookTitle.setText(this.book.getTitle());
        bookAuthors.setText(this.book.getAuthor());
        bookLanguage.setText(this.book.getLanguage());
        bookYear.setText(this.book.getYear());
    }

}
