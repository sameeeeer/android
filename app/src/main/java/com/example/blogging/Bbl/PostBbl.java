package com.example.blogging.Bbl;

import android.content.Context;

import com.example.blogging.APIs.PostApi;
import com.example.blogging.APIs.UserAPIs;
import com.example.blogging.Model.Post;
import com.example.blogging.Model.PostResponse;
import com.example.blogging.Model.Usermodel;
import com.example.blogging.RetrofitHelper.Helper;
import com.example.blogging.RetrofitHelper.UserSession;

import java.io.IOException;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

public class PostBbl {
    private PostApi postApi = Helper.getInstance().create(PostApi.class);

    boolean postcreate = false;

    public boolean uploadImage(MultipartBody.Part image, String status, Context context, String category){
        UserSession userSession = new UserSession(context);
        RequestBody poststatus = RequestBody.create(MediaType.parse("text/plain"),status);
        RequestBody user_id = RequestBody.create(MediaType.parse("text/plain"),userSession.getUser().get_id());

        Call<Void> postcall = postApi.createpost(image,user_id,poststatus,category);
        Helper.StrictMode();
        try {
            Response<Void> postResponse = postcall.execute();
            if (postResponse.isSuccessful()) {
                postcreate = true;
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        return postcreate;
    }

    public List<PostResponse> findpostbyuser(String id){
        List<PostResponse> userpostlist = null;
        Call<List<PostResponse>> listcall = postApi.getuserpost(id);
        Helper.StrictMode();
        try{
            Response<List<PostResponse>> postresponse = listcall.execute();
            if(postresponse.isSuccessful()){
                userpostlist = postresponse.body();

            }


        }catch(IOException e){
            System.out.println(e);
        }
            return userpostlist;
    }

    public boolean deletepost(String id){
        boolean isUpdatesuccess = false;
        Call<Void> deletecall = postApi.deletepost(id);
        Helper.StrictMode();
        try{
            Response<Void> deleteresponse  = deletecall.execute();
            if (deleteresponse.isSuccessful()){
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
