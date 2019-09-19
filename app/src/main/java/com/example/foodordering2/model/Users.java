package com.example.foodordering2.model;

public class Users {

    String name,pwd,email,phone;

    Users(){

    }

    public Users(String name, String pwd, String email ,String phone) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.phone=phone;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
