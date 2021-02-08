package com.example.rb_anime.repo;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitInstance {

    //Base url
    private static final String BASE_URL = "https://api.jikan.moe/v3/";

    // Declare Instance
    private static Service INSTANCE = null;

    // Make a private constructor
    private static Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create()) // Moshi converts JSON to Java
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient())
                .build();
    }

    public static Service getInstance() {
        if(INSTANCE == null)
            INSTANCE = getRetrofit().create(Service.class);
        return INSTANCE;
    }

    //Logs the API request
    private static OkHttpClient getClient() {
        HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
        logger.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(logger).build();
    }

}
