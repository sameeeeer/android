package com.example.blogging.APIs;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CommentApi {
    @POST("addcomment")
    Call<Void> addcomment(@Body RequestBody user_id, @Body RequestBody comment, @Body RequestBody post_id); //image file data type MultipartBody

}
