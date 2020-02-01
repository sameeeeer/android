package com.example.blogging.Bbl;


import android.content.Context;

import com.example.blogging.APIs.CommentApi;
import com.example.blogging.RetrofitHelper.Helper;
import com.example.blogging.RetrofitHelper.UserSession;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

public class CommentBbl {
    private CommentApi commentApi = Helper.getInstance().create(CommentApi.class);


    boolean postcomment = false;

    public boolean commentpost(String comment, Context context, String post_id){
        UserSession userSession = new UserSession(context);
        RequestBody commented = RequestBody.create(MediaType.parse("text/plain"),comment);
        RequestBody user_id = RequestBody.create(MediaType.parse("text/plain"),userSession.getUser().get_id());
        RequestBody postid = RequestBody.create(MediaType.parse("text/plain"),post_id);

        Call<Void> commentcall = commentApi.addcomment(user_id,commented,postid);
        Helper.StrictMode();
        try {
            Response<Void> commentResponse = commentcall.execute();
            if (commentResponse.isSuccessful()) {
                postcomment = true;
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        return postcomment;
    }
}
