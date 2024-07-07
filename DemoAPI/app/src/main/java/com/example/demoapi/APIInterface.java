package com.example.demoapi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

import retrofit2.http.DELETE;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
public interface APIInterface {
    public static final String BASE_URL ="http://10.0.2.2:5243/";
    //https://longorangesled14.conveyor.cloud/";//https://fastaquaboat82.conveyor.cloud/";
// "https://10.22.11.244:45457/";//
// https://demo2.conveyor.cloud/
    @GET("api/Accounts") Call<ArrayList<Account>> getAccounts();
    @GET("api/Accounts/{id}")  Call<Account> getTaiKhoanbyId(String id);
    @POST("api/Accounts")  Call<Account> PostAccount(Account taiKhoan);
    @PUT("api/Accounts/{id}")  Call<Account> PutAccount(String id, Account taiKhoan);
     @DELETE("api/Accounts/{id}")  Call<Account> DeleteAccount(String TenTK);

}