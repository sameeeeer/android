package com.example.blogging.APIs;

import com.example.blogging.Model.Usermodel;
import com.example.blogging.Responseapi.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UserAPIs {
    @POST("register")
    Call<UserResponse> registeruser(@Body Usermodel user);

    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> loginUser(@Field("email") String email, @Field("password") String password);

    @GET("profile/{id}")
    Call<Usermodel> userProfile(@Path("id") String id);


}
