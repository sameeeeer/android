package com.example.blogging.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.blogging.MapsActivity;
import com.example.blogging.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutusFragment extends Fragment {
    Button button;


    public AboutusFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_aboutus, container, false);
        button = view.findViewById(R.id.buttton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), MapsActivity.class));
            }
        });
        return view;
    }

    public static AboutusFragment newInstance() {
        AboutusFragment aboutusFragment = new AboutusFragment();
        return aboutusFragment;

    }

}
