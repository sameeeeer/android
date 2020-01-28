package com.example.blogging.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.blogging.Bbl.Userbbl;
import com.example.blogging.Model.Usermodel;
import com.example.blogging.R;
import com.example.blogging.RetrofitHelper.Helper;
import com.example.blogging.RetrofitHelper.UserSession;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileFragment extends Fragment {
    Button update;
    ImageView userimg;
    TextView txtusername, txtpoxt, txtpoxtvalue;
    ImageButton profbutton;
    UserSession userSession;
    Userbbl userbbl;

    public UserProfileFragment() {
        // Required empty public constructor
    }
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userSession = new UserSession(getActivity());
        userbbl = new Userbbl();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        txtpoxt = view.findViewById(R.id.txtpost);
        txtpoxtvalue = view.findViewById(R.id.txtpostvalue);
        userimg = view.findViewById(R.id.userProfileImg);
        profbutton = view.findViewById(R.id.imgBtnUploadPhoto);
        txtusername = view.findViewById(R.id.txtUserName);
        update = view.findViewById(R.id.btnEditProfile);
        UserProfile();
        return view;
    }

    public  void UserProfile() {
        Helper.StrictMode();
        String id=userSession.getUser().get_id();
        Toast.makeText(getActivity(), id, Toast.LENGTH_SHORT).show();
        userbbl = new Userbbl();
        Usermodel usermodel=userbbl.UserProfile(id);
        txtusername.setText(usermodel.getFname()+" "+usermodel.getLname());


    }

    public static UserProfileFragment newInstance() {
        UserProfileFragment profileFragment = new UserProfileFragment();


        return profileFragment;

    }


}
