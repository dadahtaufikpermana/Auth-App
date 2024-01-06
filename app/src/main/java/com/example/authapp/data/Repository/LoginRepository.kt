package com.example.authapp.data.Repository

import com.example.authapp.utils.Result


interface LoginRepository {
    fun loginUser(email: String, password: String, callback: (Result<Boolean>) -> Unit)
}
