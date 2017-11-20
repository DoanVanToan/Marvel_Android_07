package edu.nguyenmy.marveladroid_7.screen.main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Observable;
import android.os.Bundle;
import android.os.Parcelable;

import org.reactivestreams.Subscriber;

import java.util.ArrayList;
import java.util.List;

import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.model.CharacterList;
import edu.nguyenmy.marveladroid_7.data.source.CharacterRepository;
import edu.nguyenmy.marveladroid_7.utils.APIUtils;
import edu.nguyenmy.marveladroid_7.utils.Constant;
import edu.nguyenmy.marveladroid_7.utils.DigestUtils;
import edu.nguyenmy.marveladroid_7.utils.rx.BaseSchedulerProvider;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by DELL on 11/6/2017.
 */

public class MainViewModel extends BaseObservable {
    private Context mContext;
    private MainAdapter mMainAdapter;
    private CharacterRepository mCharacterRepository;
    private BaseSchedulerProvider mSchedulerProvider;
    private int mId;

    public MainViewModel() {

    }

    public MainViewModel(CharacterRepository characterRepository, Context context, MainAdapter adapter) {
        mCharacterRepository = characterRepository;
        mContext = context;
        mMainAdapter = adapter;
        getContentCharacter();
    }
    private void setSchedulerProvider(BaseSchedulerProvider schedulerProvider) {
        mSchedulerProvider = schedulerProvider;
    }

    private void setMainAdapter(MainAdapter mainAdapter) {
        mMainAdapter = mainAdapter;
    }

    public MainAdapter getMainAdapter() {
        return mMainAdapter;
    }

    public void getContentCharacter() {
        mCharacterRepository.getData(mId, APIUtils.ts, APIUtils.API_KEY,
                DigestUtils.getMD5(APIUtils.ts + APIUtils.API_KEY + APIUtils.PUBLIC_KEY))
                //thuc hien tren oi thread
                .subscribeOn(mSchedulerProvider.io())
                //cap nhat ket qua tren ui thread
                .observeOn(mSchedulerProvider.ui())
                .subscribe(new Observer<List<Character>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<Character> characters) {
                        getContent(characters);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void getContent(List<Character> characters) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Constant.ARGUMENT_LIST_CHARACTER,
                (ArrayList<? extends Parcelable>) characters);
    }

}
