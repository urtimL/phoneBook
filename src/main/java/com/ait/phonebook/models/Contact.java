package com.ait.phonebook.models;

public class Contact {
    private String name;
    private String lastName;
    private String phone;
    private String mail;
    private String adress;
    private String desc;

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Contact setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public Contact setAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public Contact setDesc(String desc) {
        this.desc = desc;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getAdress() {
        return adress;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
