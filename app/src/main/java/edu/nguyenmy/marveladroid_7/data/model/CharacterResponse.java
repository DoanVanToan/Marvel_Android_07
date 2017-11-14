package edu.nguyenmy.marveladroid_7.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 11/10/2017.
 */

public class CharacterResponse {

    @SerializedName("results")
    @Expose
    private List<Character> mCharacterList = new ArrayList<>();
    public CharacterResponse(List<Character> characters){
        this.mCharacterList = characters;
    }

    public List<Character> getCharacterList() {
        return mCharacterList;
    }
}
