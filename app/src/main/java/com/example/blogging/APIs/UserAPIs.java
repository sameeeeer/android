package com.example.blogging.APIs;

import com.example.blogging.Model.Usermodel;
import com.example.blogging.Responseapi.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserAPIs {
    @POST("register")
    Call<UserResponse> registeruser(@Body Usermodel user);

    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> loginUser(@Field("email") String email, @Field("password") String password);


}
