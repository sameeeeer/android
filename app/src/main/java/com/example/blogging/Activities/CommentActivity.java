package com.example.blogging.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
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
import com.example.blogging.RetrofitHelper.UserSession;
import com.example.blogging.adaptor.CommentAdaptor;

import java.util.List;

public class CommentActivity extends AppCompatActivity {
    EditText commenttxt;
    Button postcomment;
    CommentBbl commentBbl;
    CommentAdaptor commentAdaptor;
    RecyclerView commentrec;
    List<Comment> commentList;
    String postid;
    Context context;
    UserSession userSession;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        commenttxt = findViewById(R.id.commenttext);
        postcomment = findViewById(R.id.commentpost);
        commentrec = findViewById(R.id.commentrec);
        postid = getIntent().getStringExtra("postid");
        userSession = new UserSession(this);

        commentrec.setLayoutManager(new LinearLayoutManager(this));
        commentBbl = new CommentBbl();

        postcomment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid = userSession.getUser().get_id();
                String comment = commenttxt.getText().toString();


                if (commentBbl.commentpost( userid,postid,comment)) {
                    Toast.makeText(CommentActivity.this, "Comment Added", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}