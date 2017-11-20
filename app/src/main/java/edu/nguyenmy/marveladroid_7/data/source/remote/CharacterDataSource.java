package edu.nguyenmy.marveladroid_7.data.source.remote;

import java.sql.Timestamp;
import java.util.List;

import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.model.CharacterList;
import io.reactivex.Observable;

/**
 * Created by DELL on 11/18/2017.
 */

public interface CharacterDataSource {
    interface RemoteDataSource{
        Observable<List<Character>> getData(int id, Timestamp timestamp,String apiKey, String hash);
    }
}
