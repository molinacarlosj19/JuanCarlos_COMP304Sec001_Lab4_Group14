package com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "students")
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String fistName;
    private String lastName;
    private String nickName;
    private String password;
    private String email;
    private int bookId;

    public Student(String fistName, String lastName, String nickName, String password, String email, int bookId) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
        this.bookId = bookId;
    }

    public int getId() {
        return id;
    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getBookId() {
        return bookId;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", bookId=" + bookId +
                '}';
    }
}
