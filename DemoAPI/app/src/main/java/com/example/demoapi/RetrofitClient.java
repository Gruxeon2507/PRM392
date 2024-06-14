package com.example.demoapi;

import com.google.gson.Gson;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

import retrofit2.Retrofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

//cần tạo ra một đối tượng Retrofit bằng cách sử dụng lớp Retrofit.Builder

// và cấu hình nó với một URL cơ sở

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {

        OkHttpClient builder=new OkHttpClient.Builder()

                .readTimeout(5000, TimeUnit.MILLISECONDS)

                .writeTimeout(5000,TimeUnit.MILLISECONDS)

                .connectTimeout(5000,TimeUnit.MILLISECONDS)

                .build();

        Gson gson = new GsonBuilder().create();//truyền một đối tượng phân tích cú pháp GSON
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()

                    .baseUrl(baseUrl)

                    .client(builder)

                    .addConverterFactory(GsonConverterFactory.create(gson))

                    .build();

        }

        return retrofit;

    }

}