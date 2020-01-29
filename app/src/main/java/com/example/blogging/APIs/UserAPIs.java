package com.example.blogging.APIs;

import com.example.blogging.Model.Usermodel;
import com.example.blogging.Responseapi.UserResponse;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface UserAPIs {
    @POST("register")
    Call<UserResponse> registeruser(@Body Usermodel user);

    @FormUrlEncoded
    @POST("login")
    Call<UserResponse> loginUser(@Field("email") String email, @Field("password") String password);

    @GET("profile/{id}")
    Call<Usermodel> userProfile(@Path("id") String id);

    //route to update profile picture
    @Multipart //for image
    @PUT("/users/{id}/photo/upload")
    Call<Void> updateProfilePicture(@Part MultipartBody.Part img, @Header("Authorization") String authHeader, @Path("id") String id);

    @FormUrlEncoded
    @PUT("users/updates")
    Call<String> updates(@Field("_id") String id,
                              @Field("token") String token,
                              @Field("fname") String fname,
                              @Field("lname") String lname,
                              @Field("number") String number,
                              @Field("dob") String dob,
                              @Field("email") String email,
                         @Field("password") String password

    );
    @FormUrlEncoded
    @POST("users/profile")
    Call<Usermodel> loadprofile(@Field("_id") String id,
                                @Field("token") String token,
                                @Field("fname") String fname,
                                @Field("lname") String lname);
}
