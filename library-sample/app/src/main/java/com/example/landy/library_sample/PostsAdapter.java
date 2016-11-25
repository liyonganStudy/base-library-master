package com.example.landy.library_sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Post> posts;


    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_horizontal_post, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.cover.setImageResource(post.coverResId);
        holder.title.setText(post.title);
    }


    @Override public int getItemCount() {
        return posts != null ? posts.size() : 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cover;
        TextView title;


        ViewHolder(View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.cover);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}