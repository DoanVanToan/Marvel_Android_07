package edu.nguyenmy.marveladroid_7.data.source;

import edu.nguyenmy.marveladroid_7.data.model.BaseResponse;
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
    public Observable<BaseResponse> getData(long timestamp, String apiKey, String hash) {
        return mRemoteDataSource.getData(timestamp, apiKey, hash);
    }

}
