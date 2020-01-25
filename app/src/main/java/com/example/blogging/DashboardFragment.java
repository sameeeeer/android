package com.example.blogging;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogging.APIs.PostApi;
import com.example.blogging.Model.Post;
import com.example.blogging.adaptor.PostAdaptor;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    Retrofit retrofit;
    PostApi postApi;
    private RecyclerView postview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_dashboard, container, false);
        postview = root.findViewById(R.id.postlist);

        getPost();
        return root;
    }

    private void getInstance() {
        retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        postApi = retrofit.create(PostApi.class);

    }

    private void getPost(){
        getInstance();

        Call<List<Post>> postCall = postApi.getPost();

        postCall.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                List<Post> postlist = response.body();
                PostAdaptor adapter = new PostAdaptor(postlist,getContext());
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
                postview.setLayoutManager(layoutManager);
                postview.setAdapter(adapter);


//                Toast.makeText(getContext(), response.message(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
