package com.example.blogging.Bbl;

import com.example.blogging.APIs.UserAPIs;
import com.example.blogging.Model.Usermodel;
import com.example.blogging.Responseapi.UserResponse;
import com.example.blogging.RetrofitHelper.Helper;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class Userbbl {
    private UserAPIs userapi;

    public Userbbl() {

        userapi = Helper.getInstance().create(UserAPIs.class);
    }

    public boolean register(Usermodel usermodel) {
        boolean isSignUpSuccessful = false;
        Call<UserResponse> usercall = userapi.registeruser(usermodel);
        try {
            Response<UserResponse> resgResponse = usercall.execute();
            if (!resgResponse.isSuccessful()) {
                return isSignUpSuccessful;
            } else if (resgResponse.body().getSuccess() != null) {
                isSignUpSuccessful = true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSignUpSuccessful;
    }

    public Usermodel login(String email, String password) {
        Usermodel usermodel = null;
        Call<UserResponse> loginCall = userapi.loginUser(email, password);

        try {
            Response<UserResponse> loginResponse = loginCall.execute();
            if (!loginResponse.isSuccessful()) {
                return usermodel;
            } else if (loginResponse.body().getSuccess()!= null) {
                usermodel = loginResponse.body().getUser();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usermodel;
    }


}
