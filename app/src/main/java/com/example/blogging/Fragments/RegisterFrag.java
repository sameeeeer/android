package com.example.blogging.Fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.blogging.R;


public class RegisterFrag extends Fragment implements View.OnClickListener {

    EditText name, email, passwords, imagename, username, passwordds;
    Button register;


    public RegisterFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_register, container, false);

        name = view.findViewById(R.id.et_fullname_register);
        email = view.findViewById(R.id.et_email_resgister);
        passwords = view.findViewById(R.id.et_password_resgister);
        passwordds = view.findViewById(R.id.et_password2_resgister);
        username = view.findViewById(R.id.et_username_resgister);

        register=view.findViewById(R.id.btn_resigerbutton);
        register.setOnClickListener(this);
        return  view;
    }


    @Override
    public void onClick(View v) {

    }
}
