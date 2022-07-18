package com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import androidx.lifecycle.LiveData;

import com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Entity.Book;

import java.util.List;

@Dao
public interface BookDao {

    @Insert
    void insert(Book book);

    @Update
    void update(Book book);

    @Delete
    void delete(Book book);

    /*We need to modify Query
    @Query("DELETE FROM book_table")
    void deleteAllBooks();

     */

    @Query("SELECT * FROM book_table ORDER BY id DESC")
    LiveData<List<Book>> getAllNBooks();
}
