package com.example.ufmsports

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object retrofitClient {

    private const val BASE_URL = "http://dev.api.ufmsports.com/data-pipeline/v1/mock-frontend/matches/"

    private val retrofit : Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}