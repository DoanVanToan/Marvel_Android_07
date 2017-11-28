package edu.nguyenmy.marveladroid_7.screen.detail;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.model.ItemComic;
import edu.nguyenmy.marveladroid_7.data.model.ItemSeries;
import edu.nguyenmy.marveladroid_7.data.model.ItemStory;

/**
 * Created by DELL on 11/21/2017.
 */

public class DetailViewModel extends BaseObservable {
    private ComicAdapter mComicAdapter;
    private SeriesAdapter mSeriesAdapter;
    private StoryAdapter mStoryAdapter;
    private List<ItemComic> mComicList;
    private List<ItemSeries> mSeriesList;
    private List<ItemStory> mStoryList;
    private Character mCharacter;
    private String mUrlImage;
    private String mPath;
    private String mExtension;
    private String mName;

    public DetailViewModel(Character characters) {
        mComicAdapter = new ComicAdapter();
        mSeriesAdapter = new SeriesAdapter();
        mStoryAdapter = new StoryAdapter();
        mCharacter = characters;
    }
    @Bindable
    public SeriesAdapter getSeriesAdapter() {
        return mSeriesAdapter;
    }

    @Bindable
    public ComicAdapter getAdapterComic() {
        return mComicAdapter;
    }

    @Bindable
    public StoryAdapter getStoryAdapter() {
        return mStoryAdapter;
    }

    public void setComicAdapter(ComicAdapter comicAdapter) {
        mComicAdapter = comicAdapter;
    }

    public void getData() {
        mName = mCharacter.getName().toString();
        mComicList = mCharacter.getComic().getComicList();
        mSeriesList = mCharacter.getSeries().getListSeries();
        mStoryList = mCharacter.getStory().getListStory();
        mPath = mCharacter.getThumbnail().getPath();
        mComicAdapter.updateData(mComicList);
        mStoryAdapter.updateData(mStoryList);
        mSeriesAdapter.updateData(mSeriesList);
        mExtension = mCharacter.getThumbnail().getExtension();
        mUrlImage = mPath + "." + mExtension;

    }

    public String getUrlImage() {
        return mUrlImage;
    }

    public String getName() {
        return mName;
    }

}
