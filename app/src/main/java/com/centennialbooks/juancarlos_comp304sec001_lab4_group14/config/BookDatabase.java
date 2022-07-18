package com.centennialbooks.juancarlos_comp304sec001_lab4_group14.config;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Dao.BookDao;
import com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Entity.Book;
import com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Entity.Librarian;
import com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Entity.Student;

@Database(entities = {Book.class, Librarian.class, Student.class}, version = 1)
public abstract class BookDatabase extends RoomDatabase {

    private static  BookDatabase instance;

    public abstract BookDao bookDao();

    public static synchronized  BookDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    BookDatabase.class, "book_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return  instance;
    }
}
