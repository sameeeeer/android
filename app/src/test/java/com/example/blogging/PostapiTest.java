package com.example.blogging;

import com.example.blogging.APIs.PostApi;
import com.example.blogging.Model.Post;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.Mockito.when;

public class PostapiTest {
    @Test
    public void PostapiTest(){
        PostApi postApi = Mockito.mock(PostApi.class);
        final Call<Post> mockedpost = Mockito.mock(Call.class);
        when(postApi.findpost("dfghjklkjhgfghj")).thenReturn(mockedpost);

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Callback<Post>callback = invocation.getArgument(0,Callback.class);
                callback.onResponse(mockedpost, Response.success(200,new Post()));
                return null;
            }
        });
    }
//    @Test
//    public void LoginApiTest() {
//        ApiClient apiClient = Mockito.mock(ApiClient.class);
//        final Call<Result> mockedLogin = Mockito.mock(Call.class);
//        when(apiClient.Login("admin","admin")).thenReturn(mockedLogin);
//
//        Mockito.doAnswer(new Answer() {
//            @Override
//            public Object answer(InvocationOnMock invocation) throws Throwable {
//                Callback<Result> callback = invocation.getArgument(0,Callback.class);
//                callback.onResponse(mockedLogin, Response.success(new Result()));
//                return null;
//            }
//        });
//    }

}
