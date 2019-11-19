package com.example.mvp.webservices

import com.example.mvp.models.Post
import com.example.mvp.models.User
import com.example.mvp.responses.WrappedListResponse
import com.example.mvp.responses.WrappedResponse
import okhttp3.Call
import retrofit2.http.*

interface APIService {
    @GET("api/post")
    fun all(@Header("Authorization") token : String) : retrofit2.Call<WrappedListResponse<Post>>
    @FormUrlEncoded
    @POST("api/post")
    fun create(@Header("Authorization") token : String, @Field("title") title : String, @Field("content") content : String) : retrofit2.Call<WrappedResponse<Post>>
    @GET("api/post/{id}")
    fun find(@Header("Authorization") token: String, @Path("id") id: String): retrofit2.Call<WrappedResponse<Post>>

    @DELETE("api/post/{id}")
    fun delete(@Header("Authorization") token: String, @Path("id") id: String): retrofit2.Call<WrappedResponse<Post>>

    @FormUrlEncoded
    @PUT("api/post/{id}")
    fun update(@Header("Authorization") token: String, @Path("id") id: String, @Field("title") title: String, @Field("content") content: String): retrofit2.Call<WrappedResponse<Post>>

    @FormUrlEncoded
    @POST("api/login")
    fun login(@Field("email") email : String, @Field("password") password : String) : retrofit2.Call<WrappedResponse<User>>

    @FormUrlEncoded
    @POST("api/register")
    fun register(@Field("name") name : String, @Field("email") email : String, @Field("password") password : String) : retrofit2.Call<WrappedResponse<User>>

}