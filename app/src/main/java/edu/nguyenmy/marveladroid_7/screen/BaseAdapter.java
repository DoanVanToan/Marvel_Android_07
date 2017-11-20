package edu.nguyenmy.marveladroid_7.screen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 11/8/2017.
 */

public abstract class BaseAdapter<V extends RecyclerView.ViewHolder>
        extends RecyclerView.Adapter<V> {

    protected List<V> mDataList;
    public interface OnItemClickListener<V> {
        void onClickItem(V item);
    }

    public void add(List<V> itemList) {
        mDataList.addAll(itemList);
        notifyDataSetChanged();
    }

    public void set(List<V> dataList) {
        List<V> clone = new ArrayList<>(dataList);
        mDataList.clear();
        mDataList.addAll(clone);
        notifyDataSetChanged();
    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }
}
