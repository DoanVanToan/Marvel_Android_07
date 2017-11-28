package edu.nguyenmy.marveladroid_7.screen.main;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;
import java.util.List;

import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.model.CharacterResponse;
import edu.nguyenmy.marveladroid_7.data.model.BaseResponse;
import edu.nguyenmy.marveladroid_7.data.model.ItemComic;
import edu.nguyenmy.marveladroid_7.data.source.CharacterRepository;
import edu.nguyenmy.marveladroid_7.screen.BaseAdapter;
import edu.nguyenmy.marveladroid_7.screen.detail.DetailActivity;
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

public class MainViewModel extends BaseObservable implements
        BaseAdapter.OnItemClickListener<Character> {

    private static final String TAG = "MainViewModel";
    private MainAdapter mAdapter;
    private CharacterRepository mCharacterRepository;
    private CompositeDisposable mCompositeDisposable;
    private Context mContext;

    public MainViewModel(CharacterRepository characterRepository, Context context) {
        mCharacterRepository = characterRepository;
        mCompositeDisposable = new CompositeDisposable();
        mAdapter = new MainAdapter();
        mAdapter.setItemClickListerner(this);
        mContext = context;
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
                        final List<Character> characters = characterResponse.getCharacterList();
                        mAdapter.updateData(characters);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO: 11/22/2017 show error
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

    @Override
    public void onClickItem(Character item) {
        mContext.startActivity(DetailActivity.getInstance(mContext, item));
    }

}
