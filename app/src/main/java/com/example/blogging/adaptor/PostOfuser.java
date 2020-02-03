package com.example.blogging.adaptor;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogging.Activities.EditPostActivity;
import com.example.blogging.Bbl.PostBbl;
import com.example.blogging.Model.PostResponse;
import com.example.blogging.R;
import com.example.blogging.RegisterUi.NameActivity;
import com.example.blogging.RetrofitHelper.UserSession;
import com.example.blogging.Users.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostOfuser extends RecyclerView.Adapter<PostOfuser.PostHolder>{
    List<PostResponse> postlist;
    Context context;
    Fragment fragment;

    public PostOfuser(List<PostResponse> postlist, Context context, Fragment fragment) {
        this.postlist = postlist;
        this.context = context;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mypost, parent,false);
        PostHolder postHolder = new PostHolder(view);
        return postHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, final int position) {
        final PostResponse post = postlist.get(position);

        holder.postcaption.setText(post.getStatus());
        holder.profilename.setText(post.getUser_id().getFname()+" " + post.getUser_id().getLname());
        holder.category.setText(post.getCategory());

        Picasso.with(context).load("http://10.0.2.2:3000/image/"+ post.getImage()).into(holder.postimage);
        Picasso.with(context).load("http://10.0.2.2:3000/image/"+ post.getImage()).into(holder.profilepic);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PostBbl postBbl = new PostBbl();
                if(postBbl.deletepost(post.get_id())){
                    Toast.makeText(context, "Deleted successfully", Toast.LENGTH_SHORT).show();
                    FragmentTransaction fragmentTransaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.detach(fragment).attach(fragment).commit();

                }

            }


        });

        holder.updatepo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditPostActivity.class);
                intent.putExtra("Id",post.get_id());
               context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()  {
        return postlist.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder{
        CircleImageView profilepic;
        ImageView postimage;
        TextView postcaption,profilename,category;
        RelativeLayout postbox;
        Button delete, updatepo;




        public PostHolder(@NonNull View itemView) {
            super(itemView);
            profilename=itemView.findViewById(R.id.profile_name1);
            postcaption = itemView.findViewById(R.id.post_caption1);
            postimage = itemView.findViewById(R.id.post_image1);
            profilepic= itemView.findViewById(R.id.post_profileimg1);
            postbox = itemView.findViewById(R.id.post_box1);
            category = itemView.findViewById(R.id.cata1);
            delete = itemView.findViewById(R.id.delete);
            updatepo = itemView.findViewById(R.id.update11);


        }


    }



    }

