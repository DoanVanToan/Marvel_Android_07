package edu.nguyenmy.marveladroid_7.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by DELL on 11/10/2017.
 */

public class Character extends BaseObservable implements Parcelable{

    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail mThumbnail;
    @SerializedName("comics")
    @Expose
    private Comic mComic;
    @SerializedName("series")
    @Expose
    private Series mSeries;
    @SerializedName("stories")
    @Expose
    private Story mStory;

    public Comic getComic() {
        return mComic;
    }

    public Thumbnail getThumbnail() {
        return mThumbnail;
    }
    @Bindable
    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
    }
    public Series getSeries(){
        return mSeries;
    }
    public Story getStory(){
        return mStory;
    }
    protected Character(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
        mComic = Comic.class.cast(in.readValue(Comic.class.getClassLoader()));
        mSeries = Series.class.cast(in.readValue(Series.class.getClassLoader()));
        mStory = Story.class.cast(in.readValue(Story.class.getClassLoader()));
        mThumbnail = Thumbnail.class.cast(in.readValue(Thumbnail.class.getClassLoader()));

    }

    public static final Creator<Character> CREATOR = new Creator<Character>() {
        @Override
        public Character createFromParcel(Parcel in) {
            return new Character(in);
        }

        @Override
        public Character[] newArray(int size) {
            return new Character[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeString(mName);
        parcel.writeValue(mComic);
        parcel.writeValue(mSeries);
        parcel.writeValue(mStory);
        parcel.writeValue(mThumbnail);
    }

    public static class Thumbnail implements Parcelable{
        @SerializedName("path")
        @Expose
        private String mPath;
        @SerializedName("extension")
        @Expose
        private String mExtension;

        protected Thumbnail(Parcel in) {
            mPath = in.readString();
            mExtension = in.readString();
        }

        public static final Creator<Thumbnail> CREATOR = new Creator<Thumbnail>() {
            @Override
            public Thumbnail createFromParcel(Parcel in) {
                return new Thumbnail(in);
            }

            @Override
            public Thumbnail[] newArray(int size) {
                return new Thumbnail[size];
            }
        };

        public String getPath() {
            return mPath;
        }

        public void setPath(String path) {
            mPath = path;
        }

        public String getExtension() {
            return mExtension;
        }

        public void setExtension(String extension) {
            mExtension = extension;
        }

        public String getFullUrl() {
            return mPath + "." + mExtension;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(mPath);
            dest.writeString(mExtension);
        }
    }
    public static class Comic implements Parcelable{
        @SerializedName("items")
        @Expose
        private ArrayList<ItemComic> mComicList;

        public ArrayList<ItemComic> getComicList() {
            return mComicList;
        }

        public void setComicList(ArrayList<ItemComic> comicList) {
            mComicList = comicList;
        }
        protected Comic(Parcel in){
            final ClassLoader classLoader = getClass().getClassLoader();
            mComicList = in.readArrayList(classLoader);

        }

        public static final Creator<Comic> CREATOR = new Creator<Comic>() {
            @Override
            public Comic createFromParcel(Parcel in) {
                return new Comic(in);
            }

            @Override
            public Comic[] newArray(int size) {
                return new Comic[size];
            }
        };
        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeList(mComicList);
        }
    }
    public static class Series implements Parcelable{
        @SerializedName("items")
        @Expose
        private ArrayList<ItemSeries> mListSeries;

        public ArrayList<ItemSeries> getListSeries() {
            return mListSeries;
        }

        protected Series(Parcel in) {
            final ClassLoader classLoader = getClass().getClassLoader();
            mListSeries = in.readArrayList(classLoader);
        }

        public static final Creator<Series> CREATOR = new Creator<Series>() {
            @Override
            public Series createFromParcel(Parcel in) {
                return new Series(in);
            }

            @Override
            public Series[] newArray(int size) {
                return new Series[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeList(mListSeries);
        }
    }
    public static class Story implements Parcelable{
        @SerializedName("items")
        @Expose
        private ArrayList<ItemStory> mListStory;
        public ArrayList<ItemStory> getListStory() {
            return mListStory;
        }

        public void setListStory(ArrayList<ItemStory> listStory) {
            mListStory = listStory;
        }


        protected Story(Parcel in) {
            final ClassLoader classLoader = getClass().getClassLoader();
            mListStory = in.readArrayList(classLoader);
        }

        public static final Creator<Story> CREATOR = new Creator<Story>() {
            @Override
            public Story createFromParcel(Parcel in) {
                return new Story(in);
            }

            @Override
            public Story[] newArray(int size) {
                return new Story[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeList(mListStory);
        }
    }

}
