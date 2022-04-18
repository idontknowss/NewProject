package com.example.newproject

import retrofit2.Call
import retrofit2.http.*

interface RetroInterface {
        @GET("comments")
        fun getUsers(): Call<Comments>
        @POST("users")
        @FormUrlEncoded
        fun createUser(@Header("Authorization") token: String,
                       @FieldMap()
                       map: Map<String,String>
        ): Call<UserResponseItem>
        @DELETE("users/{userId}")
        fun getSingleUserDetails(@Path("userId") userId: Int): Call<UserResponseItem>
}