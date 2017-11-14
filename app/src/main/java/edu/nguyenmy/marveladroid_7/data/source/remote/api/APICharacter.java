package edu.nguyenmy.marveladroid_7.data.source.remote.api;
import java.sql.Timestamp;
import java.util.List;

import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.model.CharacterList;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by DELL on 11/10/2017.
 */

public interface APICharacter {
    @GET("/v1/public/characters")
    Observable<CharacterList> getAllCharacter(
            @Path("id") int id,
            @Query("ts") Timestamp ts,
            @Query("api_key") String apiKey,
            @Query("public_key") String hash
    );


}
