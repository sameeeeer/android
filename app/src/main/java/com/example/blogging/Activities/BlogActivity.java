package com.example.blogging.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.blogging.APIs.PostApi;
import com.example.blogging.Fragment.DashboardFragment;
import com.example.blogging.Fragment.UserProfileFragment;
import com.example.blogging.R;
import com.example.blogging.RetrofitHelper.UserSession;
import com.example.blogging.Users.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BlogActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    BottomNavigationView home_navigation, profile_navigation;
    Button imageupload, post;
    ImageView choosenimage;
    EditText statuspost;
    Uri uri;
    PostApi postApi;
    LinearLayout statusbar;
    MultipartBody.Part image;
    Button btnlogout;
    UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);


        home_navigation = findViewById(R.id.homeNavigation);
        imageupload = findViewById(R.id.image_upload);
        statuspost = findViewById(R.id.statustext);
        post = findViewById(R.id.post);
        btnlogout = findViewById(R.id.btnlogout);
        choosenimage = findViewById(R.id.image_choose);
        statusbar = findViewById(R.id.status);

//        final DashboardFragment dashboardFragment = new DashboardFragment();
//        setFragment(dashboardFragment);
        btnlogout.setOnClickListener(this);
        userSession = new UserSession(this);
        imageupload.setOnClickListener(this);
        post.setOnClickListener(this);
        loadFragment(DashboardFragment.newInstance());

        home_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment activeFragment = null;
                switch (item.getItemId()) {
                    case R.id.profile:
                        activeFragment = UserProfileFragment.newInstance();
                        break;
                    case R.id.newsfeed:
                        activeFragment = DashboardFragment.newInstance();
                        break;
                }
                loadFragment(activeFragment);
                return false;
            }
        });
    }

    private void loadFragment(Fragment activeFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, activeFragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    public void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            uri = data.getData();
            choosenimage.setImageURI(uri);
            askPermission();
        }
    }

    private void getInstance() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:3000/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        postApi = retrofit.create(PostApi.class);

    }

    public void askPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            getImgReady();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getImgReady();
            } else {
                Toast.makeText(this, "No Permission", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void getImgReady() {
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
        assert cursor != null;
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String imgPath = cursor.getString(columnIndex);
        System.out.println(imgPath);
        File file = new File(imgPath);
        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        image = MultipartBody.Part.createFormData("image", file.getName(), requestBody);
    }

    private void uploadImage(MultipartBody.Part image) {
        getInstance();

        RequestBody postcaption = RequestBody.create(MediaType.parse("text/plain"), statuspost.getText().toString());
        SharedPreferences savedata = BlogActivity.this.getSharedPreferences("User", Context.MODE_PRIVATE);
        RequestBody name = RequestBody.create(MediaType.parse("text/plain"), userSession.getUser().getFname());

        Call<Void> flagUpload = postApi.createpost(image, postcaption, name);
        System.out.println(image.toString());

        flagUpload.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Toast.makeText(BlogActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("Api Ex", t.toString());
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_upload:
                statusbar.setVisibility(View.VISIBLE);
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.
                                Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);

                break;
            case R.id.post:
                uploadImage(image);
                reload();
                break;
            case R.id.btnlogout:
                userSession.endSession();
                Intent intent1 = new Intent(BlogActivity.this, MainActivity.class);
                startActivity(intent1);
                break;

        }
    }

    public void reload() {
        Intent intent = getIntent();
        overridePendingTransition(0, 0);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
}
