package com.example.authapp.data.repository

import com.example.authapp.data.model.UserResponse
import retrofit2.Call

interface UserRepository {
    fun getUsers(page: Int, perPage: Int): Call<UserResponse>
}
