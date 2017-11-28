package edu.nguyenmy.marveladroid_7.utils;


import android.content.Context;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import edu.nguyenmy.marveladroid_7.R;
import edu.nguyenmy.marveladroid_7.data.model.Character;

/**
 * Created by DELL on 11/11/2017.
 */

public final class BindingUtils {


    @BindingAdapter({"android:recyclerAdapter"})
    public static void setAdapterForRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setAdapter(adapter);
    }

    @BindingAdapter({"android:imageUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.ic_place_holder)
                .into(imageView);
    }
}
