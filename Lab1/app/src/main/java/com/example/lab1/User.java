package com.example.lab1;

public class User {
    private String username;
    private String password;
    private String sdt;

    public User() {
    }

    public User(String username, String password, String sdt) {
        this.username = username;
        this.password = password;
        this.sdt = sdt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}