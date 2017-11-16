package edu.nguyenmy.marveladroid_7.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 11/10/2017.
 */

public class Character {

    @SerializedName("mId")
    @Expose
    private int mId;
    @SerializedName("mUrl")
    @Expose
    private String mUrl;
    @SerializedName("title")
    @Expose
    private String mName;

    public int getId() {
        return mId;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getName() {
        return mName;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public Character(int id, String url, String name) {
        this.mId = id;
        this.mUrl = url;
        this.mName = name;
    }
}
