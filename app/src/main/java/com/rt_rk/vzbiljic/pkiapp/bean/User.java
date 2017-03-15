package com.rt_rk.vzbiljic.pkiapp.bean;

/**
 * Created by vzbiljic on 14.3.17..
 */

public class User implements IBean {
    private String username;
    private String password;
    private UserType type;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        type = UserType.USER;
    }

    public User(String username, String password, UserType type) {
        this.username = username;
        this.password = password;
        this.type = type;
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

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public enum UserType{
        ADMINISTRATOR,
        USER
    }
}
