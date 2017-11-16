package edu.nguyenmy.marveladroid_7.data.source.api;



import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by DELL on 11/14/2017.
 */

public class ServiceClient {
    public static final int CONNECT_TIME_OUT = 60;
    public static OkHttpClient okHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return null;
            }
        });
        httpClient.readTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS);
        httpClient.connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS);

        return httpClient.build();
    }
    private Retrofit createRetrofit(){
       return new Retrofit.Builder()
               .client(okHttpClient())
               .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
               .addConverterFactory(GsonConverterFactory.create())
               .build();
    }

}
