package edu.nguyenmy.marveladroid_7.screen.detail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.nguyenmy.marveladroid_7.R;
import edu.nguyenmy.marveladroid_7.data.model.ItemComic;
import edu.nguyenmy.marveladroid_7.databinding.CharacterDetailBinding;

/**
 * Created by DELL on 11/23/2017.
 */

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ComicViewHolder> {
    private List<ItemComic> mComicList;
    public ComicAdapter(){
        mComicList = new ArrayList<>();
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.character_detail, parent, false);
        return new ComicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ComicViewHolder holder, int position) {
        ItemComic itemComic = mComicList.get(position);
        holder.binding(itemComic);
    }

    @Override
    public int getItemCount() {
        return mComicList == null ? 0 : mComicList.size();
    }

    public class ComicViewHolder extends RecyclerView.ViewHolder{
        private CharacterDetailBinding mBinding;
        public ComicViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
        }
        public void binding(ItemComic itemComic){
            mBinding.setDetailCharacter(itemComic);
        }
    }
    public void updateData(List<ItemComic> items) {
        if (items == null) {
            return;
        }
        mComicList.addAll(items);
        this.notifyDataSetChanged();
    }

}
