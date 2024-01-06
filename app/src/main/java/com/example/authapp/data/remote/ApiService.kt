package com.example.authapp.data.remote

import com.example.authapp.data.model.LoginRequest
import com.example.authapp.data.model.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {
    @POST("login")
    fun loginUser(@Body loginRequest: LoginRequest?): Call<LoginResponse?>?
}