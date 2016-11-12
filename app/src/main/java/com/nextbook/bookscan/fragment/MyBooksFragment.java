package com.nextbook.bookscan.fragment;

import android.support.v4.app.Fragment;
import android.widget.ListView;
import android.widget.Toast;

import com.nextbook.bookscan.R;
import com.nextbook.bookscan.adapter.MyBooksListAdapter;
import com.nextbook.bookscan.model.Book;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EFragment(R.layout.fragment_my_books)
public class MyBooksFragment extends Fragment {

    @ViewById
    ListView myBooks;

    @Bean
    MyBooksListAdapter adapter;

    @AfterViews
    void bindAdapter() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Na Drini cuprija", "Ivo Andric", "srpski", "2008", "Laguna"));
        books.add(new Book("Darkly dreaming Dexter", "Jeff Lindsay", "srpski", "2008", "Vulkan"));
        books.add(new Book("Dearly Devoted Dexter", "Jeff Lindsay", "srpski", "2008", "Hehe"));
        books.add(new Book("Dexter in the Dark", "Jeff Lindsay", "srpski", "2008", "Vulkan"));
        books.add(new Book("Double Dexter", "Jeff Lindsay", "srpski", "2008", "Laguna"));
        books.add(new Book("Dexter is Dead", "Jeff Lindsay", "srpski", "2008", "Laguna"));
        books.add(new Book("Dexter's Final Cut", "Jeff Lindsay", "srpski", "2008", "Hehe"));
        books.add(new Book("Na Drini cuprija", "Ivo Andric", "srpski", "2008", "Laguna"));
        books.add(new Book("Darkly dreaming Dexter", "Jeff Lindsay", "srpski", "2008", "Vulkan"));
        books.add(new Book("Dearly Devoted Dexter", "Jeff Lindsay", "srpski", "2008", "Hehe"));
        books.add(new Book("Dexter in the Dark", "Jeff Lindsay", "srpski", "2008", "Vulkan"));
        books.add(new Book("Double Dexter", "Jeff Lindsay", "srpski", "2008", "Laguna"));
        books.add(new Book("Dexter is Dead", "Jeff Lindsay", "srpski", "2008", "Laguna"));
        books.add(new Book("Dexter's Final Cut", "Jeff Lindsay", "srpski", "2008", "Hehe"));

        adapter.books = books;

        myBooks.setAdapter(adapter);
    }

    @ItemClick
    void myBooksItemClicked(Book book) {
        Toast.makeText(getContext(), book.getTitle(), Toast.LENGTH_SHORT).show();
    }

}
