package com.rt_rk.vzbiljic.pkiapp.bean;

/**
 * Created by vzbiljic on 14.3.17..
 */

public class User implements IBean {
    private String username;
    private String password;
    private String agency;
    private String telephone;
    private UserType type;


    public User(String username, String password, String agency, String telephone, UserType type) {
        this.username = username;
        this.password = password;
        this.agency = agency;
        this.telephone = telephone;
        this.type = type;
    }

    public User(String username, String password, String agency, String telephone) {
        this.username = username;
        this.password = password;
        this.agency = agency;
        this.telephone = telephone;
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

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public enum UserType{
        ADMINISTRATOR,
        USER
    }
}
