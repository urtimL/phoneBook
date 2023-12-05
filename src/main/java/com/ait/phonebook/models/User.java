package com.ait.phonebook.models;

public class User {
    private String mail;
    private String pass;


    public User setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public User setPass(String pass) {
        this.pass = pass;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public String getPass() {
        return pass;
    }
}
