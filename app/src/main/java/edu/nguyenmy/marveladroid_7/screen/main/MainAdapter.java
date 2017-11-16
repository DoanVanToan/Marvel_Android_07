package edu.nguyenmy.marveladroid_7.screen.main;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
    private onClickListener<Character> mItemClickListerner;

    protected MainAdapter(@NonNull Context context, List<Character> characters) {
        super(context);
        mCharacter = new ArrayList<>();
        if (characters == null) {
            return;
        }
        mCharacter.addAll(characters);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater =
                LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.character_item, parent, false);
        return new MainViewHolder(view, mItemClickListerner);

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

    public class MainViewHolder extends RecyclerView.ViewHolder {
        private onClickListener<Character> mItemClickListener;
        private CharacterItemBinding mBinding;

        public MainViewHolder(View view,
                              onClickListener<Character> clickListener) {
            super(view);
            mBinding = DataBindingUtil.bind(view);
            mItemClickListener = clickListener;
        }

        //binding dư lieu toi view
        public void binding(Character character) {
            mBinding.setItemCharacter(character);
        }
    }

}
