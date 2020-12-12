package com.example.retrofitonlinestore.api_interfaces;


import com.example.retrofitonlinestore.models.Register;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

       public interface JsonPlaceHolderApi {

    @GET("register")
    Call<List<Register>> getPosts();

    @POST("register")
    Call<Register> createPost(@Body Register reg);

}
