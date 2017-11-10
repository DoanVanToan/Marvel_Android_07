package edu.nguyenmy.marveladroid_7.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 11/10/2017.
 */

public class CharacterList {
    @SerializedName("characters")
    @Expose
    private List<Character> mCharacters = new ArrayList<>();
    public CharacterList(List<Character> characters){
        this.mCharacters = characters;
    }

    public List<Character> getCharacters() {
        return mCharacters;
    }

    public void setCharacters(List<Character> mCharacterList) {
        this.mCharacters = mCharacterList;
    }
}
