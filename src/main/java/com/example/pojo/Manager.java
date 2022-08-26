package com.example.pojo;

/**
 * 针对管理员用户表的类
 */

public class Manager {

    public String username;
    public String password;
    public String email;

    public Manager() {

    }

    public String getUsername() {
        return username;
    }

    public Manager(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
