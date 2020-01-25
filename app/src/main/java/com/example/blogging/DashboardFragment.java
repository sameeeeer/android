package com.example.blogging;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;



/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {


    private RecyclerView postview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =inflater.inflate(R.layout.fragment_dashboard, container, false);
        postview = root.findViewById(R.id.postlist);


        return root;
    }





}
