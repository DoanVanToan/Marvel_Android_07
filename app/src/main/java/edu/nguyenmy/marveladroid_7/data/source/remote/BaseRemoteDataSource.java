package edu.nguyenmy.marveladroid_7.data.source.remote;

import edu.nguyenmy.marveladroid_7.data.source.remote.api.APICharacter;

/**
 * Created by DELL on 11/18/2017.
 */

public abstract class BaseRemoteDataSource {
    APICharacter mAPICharacter;
    public BaseRemoteDataSource(APICharacter apiCharacter){
        mAPICharacter = apiCharacter;
    }
}
