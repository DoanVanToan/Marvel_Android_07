package edu.nguyenmy.marveladroid_7.utils;

import android.provider.Settings;
import java.sql.Timestamp;
import edu.nguyenmy.marveladroid_7.data.source.remote.api.APICharacter;


/**
 * Created by DELL on 11/13/2017.
 */

public class APIUtils {
    public static final String BASE_URL = "https://gateway.marvel.com/v1/";
    public static final String API_KEY = "de11038fc8b9ba43226bf2aedfb9afd71aeedc5c";
    public static final String PUBLIC_KEY = "a5c9f07294df932d988fa5bd8ef0aa7a";
    public static final Timestamp ts = new Timestamp(System.currentTimeMillis());

}
