package com.example.landy.library_sample.multitype;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.base_library.multitype.ItemViewProvider;
import com.example.landy.library_sample.R;

public class CategoryItemViewProvider extends ItemViewProvider<Category, CategoryItemViewProvider.ViewHolder> {

    @NonNull
    @Override protected ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View view = inflater.inflate(R.layout.item_category, parent, false);
        return new ViewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @NonNull Category category, int position) {
        holder.title.setText(category.title);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        @NonNull private final TextView title;


        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}