package edu.nguyenmy.marveladroid_7.data.source.remote;

import java.sql.Timestamp;
import java.util.List;

import edu.nguyenmy.marveladroid_7.data.model.Character;
import edu.nguyenmy.marveladroid_7.data.model.CharacterList;
import edu.nguyenmy.marveladroid_7.data.source.remote.api.APICharacter;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import retrofit2.Retrofit;

/**
 * Created by DELL on 11/18/2017.
 */

public class CharacterRemoteDataSource extends BaseRemoteDataSource implements CharacterDataSource.RemoteDataSource {

    public CharacterRemoteDataSource(APICharacter apiCharacter) {
        super(apiCharacter);
    }

    @Override
    public Observable<List<Character>> getData(int id, Timestamp timestamp, String apiKey, String hash) {
        return mAPICharacter.getAllCharacter(id, timestamp, apiKey, hash).
                map(new Function<CharacterList, List<Character>>() {
                    @Override
                    public List<Character> apply(CharacterList characterList) throws Exception {
                        return characterList.getCharacters();
                    }
                });
    }
}
