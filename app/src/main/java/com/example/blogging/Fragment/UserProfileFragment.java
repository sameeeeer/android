package com.example.blogging.Fragment;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.blogging.APIs.PostApi;
import com.example.blogging.Activities.BlogActivity;
import com.example.blogging.Bbl.PostBbl;
import com.example.blogging.Bbl.Userbbl;
import com.example.blogging.Model.Usermodel;
import com.example.blogging.R;
import com.example.blogging.RegisterUi.NameActivity;
import com.example.blogging.RetrofitHelper.Helper;
import com.example.blogging.RetrofitHelper.UserSession;
import com.example.blogging.Users.EdituserActivity;
import com.example.blogging.Users.MainActivity;
import com.example.blogging.adaptor.PostAdaptor;
import com.example.blogging.adaptor.PostOfuser;
import com.squareup.picasso.Picasso;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileFragment extends Fragment {
    Button update;
    ImageView userimg;
    TextView txtusername,txtemaill, txtpoxt, txtpoxtvalue;
    ImageButton profbutton;
    UserSession userSession;
    Userbbl userbbl;
    Uri uri;
    MultipartBody.Part image;
    Usermodel usermodel;
    RecyclerView postbyuser;
    PostBbl postBbl = new PostBbl();


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
        txtemaill = view.findViewById(R.id.txtemaill);
        postbyuser=view.findViewById(R.id.postlist);



        UserProfile();

        PostOfuser adapter = new PostOfuser(postBbl.findpostbyuser(userSession.getUser().get_id()),getContext(),UserProfileFragment.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        postbyuser.setLayoutManager(layoutManager);
        postbyuser.setAdapter(adapter);
        profbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.
                                Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), EdituserActivity.class);
                intent.putExtra("Id",usermodel.get_id());
                startActivity(intent);
            }
        });
        return view;

    }


    public  void UserProfile() {
        Helper.StrictMode();
        String id=userSession.getUser().get_id();
        userbbl = new Userbbl();
        usermodel = userbbl.UserProfile(id);
        txtusername.setText(usermodel.getFname()+" "+usermodel.getLname());
        txtemaill.setText(usermodel.getEmail());

        Toast.makeText(getContext(), ""+usermodel.getImages(), Toast.LENGTH_SHORT).show();

        if(usermodel.getImages()==null){
            Toast.makeText(getContext(), "null", Toast.LENGTH_SHORT).show();
        } else {
            Picasso.with(getContext()).load(Helper.IMAGE_URL + usermodel.getImages()).into(userimg);
        }

    }

    public static UserProfileFragment newInstance() {
        UserProfileFragment profileFragment = new UserProfileFragment();
        return profileFragment;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){

            String id=userSession.getUser().get_id();

            uri = data.getData();
            userimg.setImageURI(uri);
            askPermission();

            Userbbl bbl = new Userbbl();
            bbl.updateProfilePicture(image, UserSession.tokens,id);


        }
    }

    public void askPermission() {
        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.
                        WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission
                            .WRITE_EXTERNAL_STORAGE},
                    1);
        } else {
            getImgReady();
            uploadImage();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 1){
            if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                getImgReady();
                uploadImage();
            }
            else {
                Toast.makeText(getContext(), "No Permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void getImgReady(){
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContext().getContentResolver().query(uri, filePathColumn,
                null, null, null);
        assert cursor != null;
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String imgPath = cursor.getString(columnIndex);
        File file = new File(imgPath);
        RequestBody requestBody =
                RequestBody.create(MediaType.parse("image/*"),file);
        image = MultipartBody.Part.createFormData("file",
                file.getName(),requestBody);
    }

    private void uploadImage() {
        PostApi postApi = Helper.getInstance().create(PostApi.class);
        Call<Usermodel> flagUpload = postApi.uploadphoto(image, userSession.getUser().get_id());
        System.out.println(image.toString());

        flagUpload.enqueue(new Callback<Usermodel>() {
            @Override
            public void onResponse(Call<Usermodel> call, Response<Usermodel> response) {
                Toast.makeText(getContext(), "Uploaded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Usermodel> call, Throwable t) {
                Log.d("myex", t.getMessage());
            }
        });
    }






}
