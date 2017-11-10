package edu.nguyenmy.marveladroid_7.data.source.api;

import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.model.CharacterList;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by DELL on 11/10/2017.
 */

public interface APICharacter {
    @GET("/v1/public/characters")
    Observable<Character> getAllCharacter(@Query("id")int id,
                                          @Query("url") String link,
                                          @Query("title") String name);

}
