package edu.nguyenmy.marveladroid_7.utils;


import android.app.ActionBar;
import android.databinding.BindingAdapter;
import android.net.nsd.NsdManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import edu.nguyenmy.marveladroid_7.R;
import edu.nguyenmy.marveladroid_7.screen.main.MainActivity;
import edu.nguyenmy.marveladroid_7.screen.main.MainViewModel;


/**
 * Created by DELL on 11/11/2017.
 */

public final class BindingUtils {
    @BindingAdapter({"recyclerAdapter"})
    public static void setAdapterForRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter){
        recyclerView.setAdapter(adapter);
    }
}
