package com.example.blogging.APIs;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface CommentApi {
    //    @POST("addcomment")
//    Call<Void> addcomment(@Body RequestBody user_id, @Body RequestBody comment, @Body RequestBody post_id);
    @FormUrlEncoded
    @POST("postcomment")
    Call<Void> addcomment(@Field("user_id") String user_id, @Field("post_id") String post_id, @Field("comment") String comment); //image file data type MultipartBody

}
