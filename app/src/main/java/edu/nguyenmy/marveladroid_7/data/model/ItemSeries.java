package edu.nguyenmy.marveladroid_7.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 11/27/2017.
 */

public class ItemSeries implements Parcelable{
    @SerializedName("resourceURI")
    @Expose
    private String mUrl;
    @SerializedName("name")
    @Expose
    private String mNameSeries;

    protected ItemSeries(Parcel in) {
        mUrl = in.readString();
        mNameSeries = in.readString();
    }

    public static final Creator<ItemSeries> CREATOR = new Creator<ItemSeries>() {
        @Override
        public ItemSeries createFromParcel(Parcel in) {
            return new ItemSeries(in);
        }

        @Override
        public ItemSeries[] newArray(int size) {
            return new ItemSeries[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getNameSeries() {
        return mNameSeries;
    }

    public void setNameSeries(String nameSeries) {
        mNameSeries = nameSeries;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUrl);
        dest.writeString(mNameSeries);
    }
}
