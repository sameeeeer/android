package com.example.blogging.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.blogging.R;


public class LoginFrag extends Fragment implements View.OnClickListener {
    Button signup, login;
    EditText email, password;



    public LoginFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        email = view.findViewById(R.id.et_emaillogin);
        password = view.findViewById(R.id.et_password);

        signup = view.findViewById(R.id.btn_signup);
        login = view.findViewById(R.id.btn_login);

        login.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {

    }

}
