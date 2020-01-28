package com.example.blogging.Model;

public class Usermodel {
    private String fname,lname,email,dob,number,password,gender,token,_id;

    public Usermodel(String fname, String lname, String email, String dob, String number, String password, String gender, String token) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.dob = dob;
        this.number = number;
        this.password = password;
        this.gender = gender;
        this.token = token;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String get_id() {
        return _id;
    }

    public String getToken() {

        return token;

    }
}
