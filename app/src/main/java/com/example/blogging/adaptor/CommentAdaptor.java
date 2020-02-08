package com.example.blogging.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogging.Model.Comment;
import com.example.blogging.Model.CommentResponse;
import com.example.blogging.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdaptor extends RecyclerView.Adapter <CommentAdaptor.CommentHolder> {
   private List<CommentResponse> commentlist;
    private Context context;


    public CommentAdaptor(List<CommentResponse> commentlist, Context context) {
        this.commentlist = commentlist;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.commentlayout, parent,false);
        CommentHolder commentHolder = new CommentHolder(view);
        return commentHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        final CommentResponse comment = commentlist.get(position);
        holder.commentname.setText(comment.getUser_id().getFname()+" " + comment.getUser_id().getLname());
        holder.commentpost.setText(comment.getComment());
        Picasso.with(context).load("http://10.0.2.2:3000/image/" + comment.getImage()).into(holder.profilepic);
    }

    @Override
    public int getItemCount() {
        return commentlist.size();
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
        CircleImageView profilepic;
        TextView commentname, commentpost;

        public CommentHolder(@NonNull View itemView) {
            super(itemView);
            commentname=itemView.findViewById(R.id.cmmtname);
            commentpost=itemView.findViewById(R.id.post_comment);
            profilepic = itemView.findViewById(R.id.post_profileimg);
        }
    }
}
