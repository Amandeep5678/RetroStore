package com.example.retrofitonlinestore.models;

import com.google.gson.annotations.SerializedName;
public class Register {
    private int id;
    private String email;
    private String password;

    public Register( String email, String password) {

        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

