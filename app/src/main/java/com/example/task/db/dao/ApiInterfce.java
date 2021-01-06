package com.example.task.db.dao;

import com.example.task.db.model.Resturant.Login.LoginData;
import com.example.task.db.model.Resturant.Login.LoginResponse;
import com.example.task.db.model.Resturant.Order.RetJsonOrder;
import com.example.task.db.model.Resturant.RetJSON;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterfce {

    @GET("getResturants?langu=ar")
    Call<RetJSON> getResturants();

    @GET("getOrder")
    Call<RetJsonOrder> getOrder(@Query("restId") int restId, @Query("langu") String langu);

    @Headers("Content-Type: application/json")
    @POST("login")
    Call<LoginResponse> postLogin(@Body LoginData loginData);

}
