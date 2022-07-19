package com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Repository;

import android.app.Application;
import android.os.AsyncTask;


import androidx.lifecycle.LiveData;

import com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Dao.BookDao;
import com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Entity.Book;
import com.centennialbooks.juancarlos_comp304sec001_lab4_group14.config.BookDatabase;

import java.util.List;

public class BookRepository {
    private BookDao bookDao;
    private LiveData<List<Book>> allBooks;

    public  BookRepository(Application application){
        BookDatabase db = BookDatabase.getInstance(application);
        bookDao = db.bookDao();
        allBooks = bookDao.getAllBooks();
    }

    public void insert(Book book){
    new InsertBookAsyncTask(bookDao).execute(book);
    }

    public void update(Book book){
        new UpdateBookAsyncTask(bookDao).execute(book);
    }

    public void delete(Book book){
        new DeleteBookAsyncTask(bookDao).execute(book);
    }

    public void getAllBooks() {
        new DeleteAllBookAsyncTask(bookDao).execute();
    }

    private static class InsertBookAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao bookDao;

        private InsertBookAsyncTask(BookDao bookDao){
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDao.insert(books[0]);
            return null;
        }
    }

    private static class UpdateBookAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao bookDao;

        private UpdateBookAsyncTask(BookDao bookDao){
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDao.update(books[0]);
            return null;
        }
    }

    private static class DeleteBookAsyncTask extends AsyncTask<Book, Void, Void> {
        private BookDao bookDao;

        private DeleteBookAsyncTask(BookDao bookDao){
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Book... books) {
            bookDao.delete(books[0]);
            return null;
        }
    }

    private static class DeleteAllBookAsyncTask extends AsyncTask<Void, Void, Void> {
        private BookDao bookDao;

        private DeleteAllBookAsyncTask(BookDao bookDao){
            this.bookDao = bookDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            bookDao.deleteAllBooks();
            return null;
        }
    }
}
