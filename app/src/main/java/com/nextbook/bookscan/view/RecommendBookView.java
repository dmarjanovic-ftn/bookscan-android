package com.nextbook.bookscan.view;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nextbook.bookscan.R;
import com.nextbook.bookscan.model.Book;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

@EViewGroup(R.layout.item_recommend_book)
public class RecommendBookView extends LinearLayout {

    @ViewById
    ImageView cover;

    @ViewById
    TextView title;

    @ViewById
    TextView authors;

    @ViewById
    TextView rate;

    public RecommendBookView(Context context) {
        super(context);
    }

    public void bind(Book book) {
        title.setText(book.getTitle());
        authors.setText(book.getAuthor());

        // FIXME
        if ("Laguna".equals(book.getPublisher())) {
            cover.setImageResource(R.drawable.cover1);
        }
        else if ("Vulkan".equals(book.getPublisher())) {
            cover.setImageResource(R.drawable.cover2);
        }
        else {
            cover.setImageResource(R.drawable.cover3);
        }
    }
}
