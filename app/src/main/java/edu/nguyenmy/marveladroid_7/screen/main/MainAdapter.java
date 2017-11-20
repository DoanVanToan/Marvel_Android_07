package edu.nguyenmy.marveladroid_7.screen.main;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import edu.nguyenmy.marveladroid_7.R;
import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.databinding.CharacterItemBinding;
import edu.nguyenmy.marveladroid_7.screen.BaseAdapter;

/**
 * Created by DELL on 11/8/2017.
 */

public class MainAdapter extends BaseAdapter<MainAdapter.MainViewHolder> {

    private List<Character> mCharacter;
    private OnItemClickListener mItemClickListerner;

    public MainAdapter() {
        mCharacter = new ArrayList<>();
    }

    public void setItemClickListerner(OnItemClickListener itemClickListerner) {
        mItemClickListerner = itemClickListerner;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater =
                LayoutInflater.from(parent.getContext());
        CharacterItemBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.character_item, parent, false);
        return new MainViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        Character character = mCharacter.get(position);
        holder.binding(character);
    }

    @Override
    public int getItemCount() {
        return mCharacter == null ? 0 : mCharacter.size();
    }
    public void updateData(List<Character> character) {
        if (character == null) {
            return;
        }
        mCharacter.addAll(character);
        notifyDataSetChanged();
    }


    public class MainViewHolder extends RecyclerView.ViewHolder {
        private CharacterItemBinding mBinding;

        public MainViewHolder(View view) {
            super(view);
            mBinding = DataBindingUtil.bind(view);
        }
        //binding dư lieu toi view
        public void binding(Character character) {
            mBinding.setListener(mItemClickListerner);
            mBinding.setItemCharacter(character);
            mBinding.setImageUrl(character.getThumbnail());
        }
    }

}
