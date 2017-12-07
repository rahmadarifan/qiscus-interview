package com.example.android.qiscus.network;

import android.content.Context;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ifan on 12/7/2017.
 */

public class APIClient {
    public static final String BASE_URL = "http://qiscusinterview.herokuapp.com/";

    private static Retrofit retrofit = null;

    public static  Retrofit getClient(Context context){
        OkHttpClient client = new OkHttpClient.Builder().build();
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }

        return retrofit;
    }
}
