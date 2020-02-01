package com.example.blogging.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogging.Model.Comment;
import com.example.blogging.R;

import java.util.List;

public class CommentAdaptor extends RecyclerView.Adapter <CommentAdaptor.CommentHolder> {
    List<Comment> commentlist;
    Context context;

    public CommentAdaptor(List<Comment> commentlist, Context context) {
        this.commentlist = commentlist;
        this.context = context;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.commentlayout, parent,false);
        CommentHolder commentHolder = new CommentHolder(view);
        return commentHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        final Comment comment = commentlist.get(position);

        holder.commentpost.setText(comment.getComment());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
        TextView commentname, commentpost;

        public CommentHolder(@NonNull View itemView) {
            super(itemView);
            commentname=itemView.findViewById(R.id.cmmtname);
            commentpost=itemView.findViewById(R.id.post_comment);
        }
    }
}
