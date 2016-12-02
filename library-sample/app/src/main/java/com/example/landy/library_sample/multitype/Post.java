package com.example.landy.library_sample.multitype;

import android.support.annotation.NonNull;

import com.example.base_library.multitype.DisplayItem;

public class Post implements DisplayItem {

    public int coverResId;
    public String title;


    public Post(int coverResId, @NonNull final String title) {
        this.coverResId = coverResId;
        this.title = title;
    }
}