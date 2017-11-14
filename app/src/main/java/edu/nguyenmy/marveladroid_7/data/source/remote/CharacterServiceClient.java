package edu.nguyenmy.marveladroid_7.data.source.remote;

import android.app.Application;
import android.support.annotation.NonNull;

import edu.nguyenmy.marveladroid_7.data.source.remote.api.APICharacter;
import edu.nguyenmy.marveladroid_7.utils.APIUtils;

/**
 * Created by DELL on 11/17/2017.
 */

public class CharacterServiceClient {
    private static APICharacter mNameApiInstance;

    //phuong thuc khoi tao service
    public static void initialize(@NonNull Application application) {
       ServiceClient serviceClient = new ServiceClient();
       mNameApiInstance = serviceClient.createService(application,APIUtils.BASE_URL,APICharacter.class);
    }

    //kiem tra xem service duoc khoi tao chua va khoi tao
    public static APICharacter getInstance() {
        if (mNameApiInstance == null) {
            throw new RuntimeException("Need call method CharacterServiceClient#initialize() first");
        }
        return mNameApiInstance;
    }

}
