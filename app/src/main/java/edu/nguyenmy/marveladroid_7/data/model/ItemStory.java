package edu.nguyenmy.marveladroid_7.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 11/27/2017.
 */

public class ItemStory implements Parcelable {
    @SerializedName("resourceURI")
    @Expose
    private String mUrl;
    @SerializedName("name")
    @Expose
    private String mNameStory;

    protected ItemStory(Parcel in) {
        mUrl = in.readString();
        mNameStory = in.readString();
    }

    public static final Creator<ItemStory> CREATOR = new Creator<ItemStory>() {
        @Override
        public ItemStory createFromParcel(Parcel in) {
            return new ItemStory(in);
        }

        @Override
        public ItemStory[] newArray(int size) {
            return new ItemStory[size];
        }
    };

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public String getNameStory() {
        return mNameStory;
    }

    public void setNameStory(String nameStory) {
        mNameStory = nameStory;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUrl);
        dest.writeString(mNameStory);
    }
}
