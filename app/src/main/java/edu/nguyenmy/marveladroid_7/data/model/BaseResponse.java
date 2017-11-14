package edu.nguyenmy.marveladroid_7.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 11/20/2017.
 */

public class BaseResponse {
    @SerializedName("data")
    @Expose
    private CharacterResponse mCharacterResponse;

    public BaseResponse(CharacterResponse characterResponse){
        this.mCharacterResponse = characterResponse;
    }

    public CharacterResponse getCharacterResponse() {
        return mCharacterResponse;
    }
}
