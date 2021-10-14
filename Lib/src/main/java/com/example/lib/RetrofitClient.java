package com.example.lib;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static String Base_Url = "https://android-article.herokuapp.com/";
    public static Retrofit getRetrofit() {
        if(retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
