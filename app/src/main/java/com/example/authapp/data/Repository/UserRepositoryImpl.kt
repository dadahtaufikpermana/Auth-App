package com.example.authapp.data.Repository

import com.example.authapp.data.model.UserResponse
import com.example.authapp.data.remote.ApiService
import com.example.authapp.data.repository.UserRepository
import retrofit2.Call


class UserRepositoryImpl(private val apiService: ApiService) : UserRepository {

    override fun getUsers(page: Int, perPage: Int): Call<UserResponse> {
        return apiService.getUsers(page, perPage)
    }
}
