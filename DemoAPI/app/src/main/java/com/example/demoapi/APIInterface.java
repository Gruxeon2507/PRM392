package com.example.demoapi;

import java.util.List;

import retrofit2.Call;

import retrofit2.http.DELETE;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
public interface APIInterface {
    public static final String BASE_URL ="http://demo6518267.mockable.io/";
    //https://longorangesled14.conveyor.cloud/";//https://fastaquaboat82.conveyor.cloud/";
// "https://10.22.11.244:45457/";//
// https://demo2.conveyor.cloud/
    @GET("api/Accounts") Call<List<Account>> getTaiKhoans();
// @GET("api/Accounts/{id}") // Call<TaiKhoan> getTaiKhoanbyId(String id); // // @POST("api/Accounts") // Call<TaiKhoan> PostTaiKhoan(TaiKhoan taiKhoan); // // @PUT("Accounts/"+id) // Call<Account> PutTaiKhoan(String id, Account taiKhoan); // // @DELETE("api/Accounts/{id}") // Call<TaiKhoan> DeleteTaiKhoan(String TenTK);

}