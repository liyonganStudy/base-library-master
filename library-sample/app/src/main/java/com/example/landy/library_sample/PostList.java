package com.example.landy.library_sample;

import android.support.annotation.NonNull;

import com.example.base_library.multitype.DisplayItem;

import java.util.List;

public class PostList implements DisplayItem {

    final List<Post> posts;


    public PostList(@NonNull List<Post> posts) {this.posts = posts;}
}