package edu.nguyenmy.marveladroid_7.screen.detail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.nguyenmy.marveladroid_7.R;
import edu.nguyenmy.marveladroid_7.data.model.ItemStory;
import edu.nguyenmy.marveladroid_7.databinding.StoryDetailBinding;

/**
 * Created by DELL on 11/27/2017.
 */

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.StoryViewHolder> {
    private List<ItemStory> mStoryList;
    public StoryAdapter(){
        mStoryList = new ArrayList<>();
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.story_detail, parent, false);
        return new StoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StoryViewHolder holder, int position) {
        ItemStory itemStory = mStoryList.get(position);
        holder.binding(itemStory);
    }

    @Override
    public int getItemCount() {
        return mStoryList == null ? 0 : mStoryList.size();
    }

    public class StoryViewHolder extends RecyclerView.ViewHolder{
        private StoryDetailBinding mBinding;
        public StoryViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }
        public void binding(ItemStory itemStory){
            mBinding.setStoryDetail(itemStory);
        }
    }
    public void updateData(List<ItemStory> items) {
        if (items == null) {
            return;
        }
        mStoryList.addAll(items);
        this.notifyDataSetChanged();
    }

}
