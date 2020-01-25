package com.example.blogging.APIs;


import com.example.blogging.Model.Post;
import com.example.blogging.RetrofitHelper.Helper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class postapiheandel {

    PostApi postApi = Helper.getInstance().create(PostApi.class);
    List<Post> postdata;

    public List<Post> getpost(){
        Call<List<Post>> postCall = postApi.getPost();

        try{
            Response<List<Post>> gettpost = postCall.execute();
            postdata =  gettpost.body();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  postdata;
    }


}
