package com.example.blogging.Bbl;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import com.example.blogging.APIs.UserAPIs;
import com.example.blogging.Activities.BlogActivity;
import com.example.blogging.Model.Usermodel;
import com.example.blogging.Responseapi.UserResponse;
import com.example.blogging.RetrofitHelper.Helper;
import com.example.blogging.RetrofitHelper.UserSession;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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
            } else if (loginResponse.body().getSuccess().equals("true")) {
                usermodel = loginResponse.body().getUser();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usermodel;
    }
    public Usermodel UserProfile(String id){
        Usermodel usermodel = null;
        Call<Usermodel> profilecall = userapi.userProfile(id);

        try {
            Response<Usermodel> profileResponse = profilecall.execute();
            if (profileResponse.isSuccessful()) {
                usermodel = profileResponse.body();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return usermodel;
    }
    public void updateProfilePicture(MultipartBody.Part img, String authHeader, String id){
        Call<Void> userCall = userapi.updateProfilePicture(img, authHeader, id);
        try {
            Response<Void> response = userCall.execute();
            if(response.isSuccessful()){
                Log.d("res", ""+response.body());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean updateProfile(Usermodel usermodel,String id){
        boolean isUpdatesuccess = false;
        Call<Void> userCall = userapi.updateProfile(id,usermodel);
        Helper.StrictMode();
        try{
            Response<Void> checkresponse  = userCall.execute();
            System.out.println(checkresponse.isSuccessful());
            if (checkresponse.isSuccessful()){
                isUpdatesuccess = true;

            }
            else{
                isUpdatesuccess=false;
            }
        }catch (IOException e)
        {
            System.out.println(e);
        }

        return isUpdatesuccess;
    }


}
