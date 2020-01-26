package com.example.blogging.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogging.Model.Post;
import com.example.blogging.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdaptor extends RecyclerView.Adapter<PostAdaptor.PostHolder>{

    List<Post> postlist;
    Context context;

    public PostAdaptor(List<Post> postlist , Context context) {
        this.context = context;
        this.postlist = postlist;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.blog, parent,false);
        PostHolder postHolder = new PostHolder(view);
        return postHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {
        final Post post = (Post) postlist.get(position);

        holder.postcaption.setText(post.getStatus());
        holder.profilename.setText(post.getName());
        Picasso.with(context).load("http://10.0.2.2:3000/image/"+ post.getImage()).into(holder.postimage);
        Picasso.with(context).load("http://10.0.2.2:3000/image/"+ post.getImage()).into(holder.profilepic);

    }

    @Override
    public int getItemCount() {
        return postlist.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder{
        CircleImageView profilepic;
        ImageView postimage;
        TextView postcaption,profilename;
        RelativeLayout postbox;



        public PostHolder(@NonNull View itemView) {
            super(itemView);
            profilename=itemView.findViewById(R.id.profile_name);
            postcaption = itemView.findViewById(R.id.post_caption);
            postimage = itemView.findViewById(R.id.post_image);
            profilepic= itemView.findViewById(R.id.post_profileimg);
            postbox = itemView.findViewById(R.id.post_box);
        }
    }
}