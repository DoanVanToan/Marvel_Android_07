package edu.nguyenmy.marveladroid_7.screen.main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.widget.Toolbar;

import edu.nguyenmy.marveladroid_7.BR;

/**
 * Created by DELL on 11/6/2017.
 */

public class MainViewModel extends BaseObservable {
    private Context mContext;
    private MainAdapter mMainAdapter;
    public MainViewModel(){

    }
    public MainViewModel(Context context, MainAdapter mainAdapter) {
        mContext = context;
        mMainAdapter = mainAdapter;
    }

    public MainAdapter getMainAdapter() {
        return mMainAdapter;
    }
}
