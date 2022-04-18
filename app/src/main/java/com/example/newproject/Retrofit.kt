package com.example.newproject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    var retrofitbuilder=Retrofit.Builder().baseUrl(
            "https://gorest.co.in/public/v2/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var retroInterface=retrofitbuilder.create(RetroInterface::class.java)

}