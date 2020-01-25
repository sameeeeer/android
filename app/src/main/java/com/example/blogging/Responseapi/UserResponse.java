package com.example.blogging.Responseapi;

import com.example.blogging.Model.Usermodel;

public class UserResponse {
    private String success;
    public Usermodel user;
    public String token;

    public String getToken() {
        return token;
    }

    public String getSuccess() {
        return success;
    }

    public Usermodel getUser() {
        return user;
    }
}
