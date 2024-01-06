package com.example.authapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://reqres.in/api/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getApiService(): ApiService = retrofit.create(ApiService::class.java)

    fun create(): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}