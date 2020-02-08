package com.example.blogging.Bbl;


import android.content.Context;

import com.example.blogging.APIs.CommentApi;
import com.example.blogging.Model.CommentResponse;
import com.example.blogging.RetrofitHelper.Helper;
import com.example.blogging.RetrofitHelper.UserSession;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

public class CommentBbl {
    private CommentApi commentApi = Helper.getInstance().create(CommentApi.class);


    boolean postcomment = false;

    //    public boolean commentpost(String comment, Context context, String post_id){
//        UserSession userSession = new UserSession(context);
//        RequestBody commented = RequestBody.create(MediaType.parse("text/plain"),comment);
//        RequestBody user_id = RequestBody.create(MediaType.parse("text/plain"),userSession.getUser().get_id());
//        RequestBody postid = RequestBody.create(MediaType.parse("text/plain"),post_id);
//
//        Call<Void> commentcall = commentApi.addcomment(user_id,commented,postid);
//        Helper.StrictMode();
//        try {
//            Response<Void> commentResponse = commentcall.execute();
//            if (commentResponse.isSuccessful()) {
//                postcomment = true;
//            }
//        }
//        catch(IOException e){
//            System.out.println(e);
//        }
//        return postcomment;
//    }
    public boolean commentpost(String userid, String post_id,String comment) {

        Call<Void> commentcall = commentApi.addcomment(userid, post_id,comment);
        Helper.StrictMode();
        try {
            Response<Void> commentResponse = commentcall.execute();
            if (commentResponse.isSuccessful()) {
                postcomment = true;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return postcomment;
    }


    public List<CommentResponse> findcommentbyId(String id){
        List<CommentResponse> commentpostlist = null;
        Call<List<CommentResponse>> listcall = commentApi.commentpost(id);
        Helper.StrictMode();
        try{
            Response<List<CommentResponse>> commentResponse = listcall.execute();
            if(commentResponse.isSuccessful()){
                commentpostlist = commentResponse.body();

            }


        }catch(IOException e){
            System.out.println(e);
        }
        return commentpostlist;
    }
}

