package edu.nguyenmy.marveladroid_7.screen.detail;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import edu.nguyenmy.marveladroid_7.data.model.ItemComic;
import edu.nguyenmy.marveladroid_7.data.model.ItemSeries;
import edu.nguyenmy.marveladroid_7.data.model.ItemView;
import edu.nguyenmy.marveladroid_7.databinding.CharacterDetailBinding;
import edu.nguyenmy.marveladroid_7.databinding.SeriesDetailBinding;
import edu.nguyenmy.marveladroid_7.screen.BaseAdapter;

/**
 * Created by DELL on 11/23/2017.
 */

public abstract class DetailAdapter extends BaseAdapter<DetailAdapter.DetailViewHolder> {
    public class DetailViewHolder extends RecyclerView.ViewHolder {
        private CharacterDetailBinding mBinding;
        private SeriesDetailBinding mSeriesDetailBinding;

        public DetailViewHolder(View itemView) {
            super(itemView);
            mBinding = DataBindingUtil.bind(itemView);
            mSeriesDetailBinding = DataBindingUtil.bind(itemView);
        }
        public void binding(ItemComic itemComic){
            mBinding.setDetailCharacter(itemComic);
        }
        public void bindingSeries(ItemSeries itemSeries){
            mSeriesDetailBinding.setSeriesDetail(itemSeries);
        }
    }

}
