package edu.nguyenmy.marveladroid_7.data.source.remote.api;
import edu.nguyenmy.marveladroid_7.data.model.BaseResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by DELL on 11/10/2017.
 */

public interface APICharacter {

    @GET("v1/public/characters")
    Observable<BaseResponse> getAllCharacter(
            @Query("ts") long ts,
            @Query("apikey") String apiKey,
            @Query("hash") String hash
    );

}
