package edu.nguyenmy.marveladroid_7.data.source.remote.service;


import android.app.Application;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by DELL on 11/14/2017.
 */

public class ServiceClient {
    public static final int CONNECTION_TIME_OUT = 60;

    static <T> T createService(Application application, String endPoint, Class<T> serviceClass) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        int cacheSize = 10 * 1024 * 1024; // 10 MiB

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .cache(new Cache(application.getCacheDir(), cacheSize))
                .addInterceptor(logging)
                .readTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS);

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(endPoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(httpClientBuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(serviceClass);
    }


}
