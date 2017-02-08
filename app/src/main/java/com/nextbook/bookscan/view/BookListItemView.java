package com.nextbook.bookscan.view;


import android.content.Context;
import android.support.v7.widget.AppCompatRatingBar;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nextbook.bookscan.R;
import com.nextbook.bookscan.model.Book;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.item_recommend_book)
public class BookListItemView extends LinearLayout {

    @ViewById
    ImageView cover;

    @ViewById
    TextView title;

    @ViewById
    TextView authors;

    @ViewById
    AppCompatRatingBar rate;

    public BookListItemView(Context context) {
        super(context);
    }

    public void bind(Book book) {
        title.setText(book.getTitle());
        authors.setText(book.getAuthors());
    }
}