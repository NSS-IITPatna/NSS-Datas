package com.example.nssdatas.Models;

import com.example.nssdatas.ThankFragment;

public class ThankModel {
    String email;
    String name;
    String phone;
    String thought;

    public ThankModel(){}

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getThought() {
        return thought;
    }

    public void setThought(String thought) {
        this.thought = thought;
    }
}
