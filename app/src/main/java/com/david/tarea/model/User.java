package com.david.tarea.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name = "fullName")
    public String fullName;
    @ColumnInfo(name = "email")
    public String email;
    @ColumnInfo(name = "password")
    public String password;

    public User(){}

    public User(String name, String email, String password) {
        this.fullName = name;
        this.email = email;
        this.password = password;
    }
}
