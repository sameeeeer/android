package com.example.blogging.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blogging.Bbl.PostBbl;
import com.example.blogging.Model.Post;
import com.example.blogging.R;

public class EditPostActivity extends AppCompatActivity {
EditText txtcate, txtdesc;
Button btnup;
PostBbl postBbl = new PostBbl();
Post post ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_post);
        post = postBbl.findpost(getIntent().getStringExtra("Id"));


        txtcate = findViewById(R.id.category);
        txtdesc = findViewById(R.id.stat);
        btnup = findViewById(R.id.Update);

        txtcate.setText(post.getCategory());
        txtdesc.setText(post.getStatus());
        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Post post = new Post(txtdesc.getText().toString(),txtcate.getText().toString());
                if (postBbl.updatepost(getIntent().getStringExtra("Id"),post)){
                    Toast.makeText(EditPostActivity.this, "Post Updated", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });


    }
}
