package com.example.landy.library_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.base_library.multitype.DisplayItem;
import com.example.base_library.multitype.MultiTypeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int SPAN_COUNT = 2;
    private List<DisplayItem> items;
    private MultiTypeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JsonData data = new JsonData();
        items = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            /* You also could use Category as your CategoryItemContent directly */
            items.add(data.category0);
            items.add(data.postArray[0]);
            items.add(data.postArray[1]);
            items.add(data.postArray[2]);
            items.add(data.postArray[3]);
            items.add(new PostList(data.postList));
        }

        adapter = new MultiTypeAdapter();
        adapter.registerMultiType(Post.class, new PostViewProvider());
        adapter.registerMultiType(Category.class, new CategoryItemViewProvider());
        adapter.registerMultiType(PostList.class, new HorizontalPostsViewProvider());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        final GridLayoutManager layoutManager = new GridLayoutManager(this, SPAN_COUNT);
        GridLayoutManager.SpanSizeLookup spanSizeLookup = new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                DisplayItem item = items.get(position);
                return (item instanceof PostList || item instanceof Category) ? SPAN_COUNT : 1;
            }
        };
        layoutManager.setSpanSizeLookup(spanSizeLookup);
        recyclerView.setLayoutManager(layoutManager);
//        int space = getResources().getDimensionPixelSize(R.dimen.normal_space);
//        recyclerView.addItemDecoration(new PostItemDecoration(space, spanSizeLookup));
        recyclerView.setAdapter(adapter);
        adapter.setItems(items);

    }

    private static class JsonData {

        private final String PREFIX = "这是一条长长的达到两行的标题文字";
        Category category0 = new Category("title0");
        List<Post> postList = new ArrayList<>();
        private Post post00 = new Post(R.drawable.img_00, PREFIX + "post00");
        private Post post01 = new Post(R.drawable.img_01, PREFIX + "post01");
        private Post post10 = new Post(R.drawable.img_10, PREFIX + "post10");
        private Post post11 = new Post(R.drawable.img_11, PREFIX + "post11");
        Post[] postArray = {post00, post01, post10, post11};

        {
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
            postList.add(post00);
        }
    }
}
