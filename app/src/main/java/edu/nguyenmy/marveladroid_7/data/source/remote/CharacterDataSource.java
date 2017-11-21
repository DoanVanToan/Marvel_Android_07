package edu.nguyenmy.marveladroid_7.data.source.remote;

import edu.nguyenmy.marveladroid_7.data.model.BaseResponse;
import io.reactivex.Observable;

/**
 * Created by DELL on 11/18/2017.
 */

public interface CharacterDataSource {

    interface RemoteDataSource {
        Observable<BaseResponse> getData(long timestamp, String apiKey, String hash);
    }
}
