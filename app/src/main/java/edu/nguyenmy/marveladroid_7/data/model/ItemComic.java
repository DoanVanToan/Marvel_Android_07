package edu.nguyenmy.marveladroid_7.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 11/23/2017.
 */

public class ItemComic implements Parcelable{
    @SerializedName("resourceURI")
    @Expose
    private String mUrl;
    @SerializedName("name")
    @Expose
    private String mNameComic;

    public String getUrl() {
        return mUrl;
    }

    public ItemComic(Parcel in){
        mUrl = in.readString();
        mNameComic = in.readString();
    }
    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getNameComic() {
        return mNameComic;
    }

    public void setNameComic(String nameComic) {
        this.mNameComic = nameComic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mUrl);
        parcel.writeString(mNameComic);
    }
    public static final Creator<ItemComic> CREATOR = new Creator<ItemComic>() {
        @Override
        public ItemComic createFromParcel(Parcel in) {
            return new ItemComic(in);
        }

        @Override
        public ItemComic[] newArray(int size) {
            return new ItemComic[size];
        }
    };
}
