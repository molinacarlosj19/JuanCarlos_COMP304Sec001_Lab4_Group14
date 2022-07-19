package com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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

    @Query("DELETE FROM books")
    void deleteAllBooks();

    @Query("SELECT * FROM books ORDER BY id DESC")
    LiveData<List<Book>> getAllBooks();

}
