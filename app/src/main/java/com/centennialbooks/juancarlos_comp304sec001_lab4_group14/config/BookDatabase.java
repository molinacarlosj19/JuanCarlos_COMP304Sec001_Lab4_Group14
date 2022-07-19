package com.centennialbooks.juancarlos_comp304sec001_lab4_group14.config;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

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
                    .addCallback(roomCallback)
                    .build();
        }

        return  instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static  class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
        private BookDao bookDao;

        private PopulateDbAsyncTask(BookDatabase db){
            bookDao = db.bookDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            bookDao.insert(new Book("Arkitect Patterns", "Carlos Molina", "About clean arkitect", "Tech", 10));
            bookDao.insert(new Book("System Design", "Lu Xin", "About Design", "Tech", 5));
            bookDao.insert(new Book("The war", "Liz A", "War in the world", "Fiction", 3));
            return null;
        }
    }
}
