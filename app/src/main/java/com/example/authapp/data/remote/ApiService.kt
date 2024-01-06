package com.example.authapp.data.remote

import com.example.authapp.data.model.LoginRequest
import com.example.authapp.data.model.LoginResponse
import com.example.authapp.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {
    @POST("login")
    fun loginUser(@Body loginRequest: LoginRequest?): Call<LoginResponse?>?

    @GET("users")
    fun getUsers(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): Call<UserResponse>
}