package com.nextbook.bookscan.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.nextbook.bookscan.model.Book;
import com.nextbook.bookscan.view.BookListItemView;
import com.nextbook.bookscan.view.BookListItemView_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class RecommendedBooksListAdapter extends BaseAdapter {

    public List<Book> books;

    @RootContext
    Context context;

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Book getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BookListItemView bookListItemView;

        if (convertView == null) {
            bookListItemView = BookListItemView_.build(context);
        }
        else {
            bookListItemView = (BookListItemView) convertView;
        }

        bookListItemView.bind(getItem(position));

        return bookListItemView;
    }
}
