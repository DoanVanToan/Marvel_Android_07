package edu.nguyenmy.marveladroid_7.screen.detail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.nguyenmy.marveladroid_7.R;
import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.model.ItemComic;
import edu.nguyenmy.marveladroid_7.data.model.ItemSeries;
import edu.nguyenmy.marveladroid_7.databinding.CharacterDetailBinding;
import edu.nguyenmy.marveladroid_7.databinding.SeriesDetailBinding;

/**
 * Created by DELL on 11/27/2017.
 */

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.SeriesViewHolder>{
    private List<ItemSeries> mSeriesList;
    public SeriesAdapter(){
        mSeriesList = new ArrayList<>();
    }

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.series_detail, parent, false);
        return new SeriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SeriesViewHolder holder, int position) {
        ItemSeries itemSeries = mSeriesList.get(position);
        holder.binding(itemSeries);
    }

    @Override
    public int getItemCount() {
        return mSeriesList == null ? 0 : mSeriesList.size();
    }

    public class SeriesViewHolder extends RecyclerView.ViewHolder{
        private SeriesDetailBinding mSeriesDetailBinding;
        public SeriesViewHolder(View itemView) {
            super(itemView);
            mSeriesDetailBinding = DataBindingUtil.bind(itemView);
        }
        public void binding(ItemSeries itemSeries){
            mSeriesDetailBinding.setSeriesDetail(itemSeries);
        }
    }

    public void updateData(List<ItemSeries> items) {
        if (items == null) {
            return;
        }
        mSeriesList.addAll(items);
        this.notifyDataSetChanged();
    }
}
