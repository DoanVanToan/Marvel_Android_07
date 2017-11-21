package edu.nguyenmy.marveladroid_7.data.source.remote;

import edu.nguyenmy.marveladroid_7.data.model.BaseResponse;
import edu.nguyenmy.marveladroid_7.data.source.remote.api.APICharacter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;

/**
 * Created by DELL on 11/18/2017.
 */

public class CharacterRemoteDataSource extends BaseRemoteDataSource implements CharacterDataSource.RemoteDataSource {

    public CharacterRemoteDataSource(APICharacter apiCharacter) {
        super(apiCharacter);
    }

    @Override
    public Observable<BaseResponse> getData(long timeStamp, String apiKey, String hash) {
        return mAPICharacter.getAllCharacter( timeStamp, apiKey, hash);
    }
}
