package com.example.blogging.APIs;


import com.example.blogging.Model.Post;
import com.example.blogging.Model.PostResponse;
import com.example.blogging.Model.Usermodel;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface PostApi {
    @GET("findpost")
    Call<List<PostResponse>> getPost();


    @Multipart //for image
    @POST("createpost")
    Call<Void> createpost(@Part MultipartBody.Part img, @Part("user_id") RequestBody user_id, @Part("status") RequestBody status, @Part("category") String category); //image file data type MultipartBody

    @Multipart
    @PUT("upload/{id}")
    Call<Usermodel> uploadphoto(@Part MultipartBody.Part img, @Path("id") String id);

    @GET("findpostbyuserid/{id}")
    Call<List<PostResponse>> getuserpost(@Path("id") String id);

    @DELETE("deletepost/{id}")
    Call<Void> deletepost(@Path("id") String id);

}
