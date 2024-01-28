package com.example.myapplication;

import android.widget.EditText;

public class ApplicationAccount {
    private String email;
    private String username;
    private String age;
    private String password;

    public ApplicationAccount(String email, String username, String age, String password) {
        this.email = email;
        this.username = username;
        this.age = age;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
