package com.example.blogging.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.blogging.Bbl.CommentBbl;
import com.example.blogging.Model.Comment;
import com.example.blogging.Model.Post;
import com.example.blogging.R;

public class CommentActivity extends AppCompatActivity {
    EditText commenttxt;
    Button postcomment;
    CommentBbl commentBbl = new CommentBbl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        commenttxt = findViewById(R.id.commenttext);
        postcomment = findViewById(R.id.commentpost);


        postcomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }
}