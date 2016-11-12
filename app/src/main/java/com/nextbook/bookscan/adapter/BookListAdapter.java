package com.nextbook.bookscan.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.nextbook.bookscan.model.Book;
import com.nextbook.bookscan.view.RecommendBookView;
import com.nextbook.bookscan.view.RecommendBookView_;
import com.nextbook.bookscan.view.ViewWrapper;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class BookListAdapter extends RecyclerViewAdapterBase<Book, RecommendBookView> {

    @RootContext
    Context context;

    @Override
    protected RecommendBookView onCreateItemView(ViewGroup parent, int viewType) {
        return RecommendBookView_.build(context);
    }

    @Override
    public void setItems(List<Book> items) {
        this.items = items;
    }

    @Override
    public void onBindViewHolder(ViewWrapper<RecommendBookView> holder, int position) {
        RecommendBookView view = holder.getView();
        Book book = items.get(position);

        view.bind(book);
    }
}
