package edu.nguyenmy.marveladroid_7.data.source;

import java.sql.Timestamp;
import java.util.List;

import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.model.CharacterList;
import edu.nguyenmy.marveladroid_7.data.source.remote.CharacterDataSource;
import io.reactivex.Observable;

/**
 * Created by DELL on 11/18/2017.
 */

public class CharacterRepository {
    private CharacterDataSource.RemoteDataSource mRemoteDataSource;

    public CharacterRepository(CharacterDataSource.RemoteDataSource remoteDataSource) {
        mRemoteDataSource = remoteDataSource;
    }

    public Observable<List<Character>> getData(int id, Timestamp timestamp, String apiKey, String hash) {
        return mRemoteDataSource.getData(id, timestamp, apiKey, hash);
    }

}
