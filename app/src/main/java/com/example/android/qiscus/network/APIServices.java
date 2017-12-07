package com.example.android.qiscus.network;

import com.example.android.qiscus.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Ifan on 12/7/2017.
 */

public interface APIServices {
    @GET("products")
    Call<List<Products.Main>> getProduct();

    @POST("products?")
    Call<Products.Main> setProduct(@Query("product[name]") String name, @Query("product[price]") String Price, @Query("product[description]") String desc);
}
