package edu.nguyenmy.marveladroid_7.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.util.Log;

import java.util.List;

import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.model.CharacterResponse;
import edu.nguyenmy.marveladroid_7.data.model.BaseResponse;
import edu.nguyenmy.marveladroid_7.data.source.CharacterRepository;
import edu.nguyenmy.marveladroid_7.utils.APIUtils;
import edu.nguyenmy.marveladroid_7.utils.DigestUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by DELL on 11/6/2017.
 */

public class MainViewModel extends BaseObservable {
    private static final String TAG = "MainViewModel";
    private MainAdapter mAdapter;
    private CharacterRepository mCharacterRepository;
    private CompositeDisposable mCompositeDisposable;

    public MainViewModel(CharacterRepository characterRepository) {
        mCharacterRepository = characterRepository;
        mCompositeDisposable = new CompositeDisposable();
        mAdapter = new MainAdapter();
    }
    @Bindable
    public MainAdapter getAdapter() {
        return mAdapter;
    }

    public void getContentCharacter() {
        long ts = System.currentTimeMillis();
        String md5Str = new StringBuilder()
                .append(ts)
                .append(APIUtils.PRIVATE_API_KEY)
                .append(APIUtils.PUBLIC_KEY)
                .toString();

        Disposable disposable = mCharacterRepository
                .getData(ts, APIUtils.PUBLIC_KEY, DigestUtils.getMD5(md5Str))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<BaseResponse>() {
                    @Override
                    public void onNext(BaseResponse objectResponse) {
                        CharacterResponse characterResponse = objectResponse.getCharacterResponse();
                        List<Character> characters = characterResponse.getCharacterList();
                        mAdapter.updateData(characters);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Main View Model", e.getMessage() + "");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        mCompositeDisposable.add(disposable);
    }

    public void onStop() {
        mCompositeDisposable.clear();
    }



}
