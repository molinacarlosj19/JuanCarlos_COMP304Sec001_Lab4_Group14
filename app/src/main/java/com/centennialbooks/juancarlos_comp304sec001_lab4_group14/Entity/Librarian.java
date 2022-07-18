package com.centennialbooks.juancarlos_comp304sec001_lab4_group14.Entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "librarians")
public class Librarian {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String fistName;
    private String lastName;
    private String nickName;
    private String password;
    private String email;

    public Librarian(String fistName, String lastName, String nickName, String password, String email) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.password = password;
        this.email = email;
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

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "id=" + id +
                ", fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
