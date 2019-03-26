package com.android.ioasys.boca_agua.service;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class ServiceGenerator {

    private static final String BASE_URL = "https://d17h27t6h515a5.cloudfront.net/";

    public static <S> S createService(Class<S> serviceClass){

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS);

        clientBuilder.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(clientBuilder.build())
                .build();

        return retrofit.create(serviceClass);
    }
}
