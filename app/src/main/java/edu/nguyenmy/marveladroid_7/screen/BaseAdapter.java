package edu.nguyenmy.marveladroid_7.screen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

/**
 * Created by DELL on 11/8/2017.
 */

public abstract class BaseAdapter<V extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<V> {
    private final Context mContext;

    protected BaseAdapter(@NonNull Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    public interface onClickListener<V> {
        void onClickItem(V item);
    }

}
