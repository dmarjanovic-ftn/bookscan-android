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

    /* @AfterInject
    void initBooks() {
        books.add(new Book("Na Drini cuprija", "Ivo Andric", "srpski", "2008", "Laguna"));
        books.add(new Book("Darkly dreaming Dexter", "Jeff Lindsay", "srpski", "2008", "Vulkan"));
        books.add(new Book("Dearly Devoted Dexter", "Jeff Lindsay", "srpski", "2008", "Vulkan"));
        books.add(new Book("Dexter in the Dark", "Jeff Lindsay", "srpski", "2008", "Laguna"));
        books.add(new Book("Double Dexter", "Jeff Lindsay", "srpski", "2008", "Laguna"));
        books.add(new Book("Dexter is Dead", "Jeff Lindsay", "srpski", "2008", "Vulkan"));
        books.add(new Book("Dexter's Final Cut", "Jeff Lindsay", "srpski", "2008", "Laguna"));
    } */

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
