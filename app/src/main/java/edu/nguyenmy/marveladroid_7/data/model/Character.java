package edu.nguyenmy.marveladroid_7.data.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.net.URL;
import java.util.List;

import edu.nguyenmy.marveladroid_7.BR;

/**
 * Created by DELL on 11/10/2017.
 */

public class Character extends BaseObservable {

    @SerializedName("id")
    @Expose
    private int mId;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail mThumbnail;

    public Thumbnail getThumbnail() {
        return mThumbnail;
    }

    @Bindable
    public String getName() {
        return this.mName;
    }

    public void setName(String name) {
        this.mName = name;
        notifyPropertyChanged(BR.itemCharacter);
    }

    public class Thumbnail {
        @SerializedName("path")
        @Expose
        private String mPath;
        @SerializedName("extension")
        @Expose
        private String mExtension;

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
    }
}
