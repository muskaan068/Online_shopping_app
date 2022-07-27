package com.example.onlineshopping;

public class User {

    private int id;
    private String name=null;
    private String email;
    private String pwsd;
    public User()
    {};

    public User(int id, String name, String email, String pwsd) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pwsd = pwsd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwsd() {
        return pwsd;
    }

    public void setPwsd(String pwsd) {
        this.pwsd = pwsd;
    }
}

