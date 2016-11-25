package com.example.landy.library_sample;

import android.support.annotation.NonNull;

import com.example.base_library.multitype.DisplayItem;

/**
 * Created by landy on 16/11/25.
 *
 */
public class Category implements DisplayItem {

    public String title;


    public Category(@NonNull final String title) {
        this.title = title;
    }
}
