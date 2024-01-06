package com.example.authapp.data.Repository

import android.content.Context
import android.content.SharedPreferences
import com.example.authapp.data.model.LoginRequest
import com.example.authapp.data.model.LoginResponse
import com.example.authapp.data.remote.ApiClient
import com.example.authapp.utils.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val SHARED_PREFERENCES_NAME = "auth_preferences"
private const val LOGIN_STATUS_KEY = "login_status"

class LoginRepositoryImpl(private val context: Context) : LoginRepository {
    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    override fun loginUser(email: String, password: String, callback: (Result<Boolean>) -> Unit) {
        val loginRequest = LoginRequest(email, password)
        val call = ApiClient.getApiService().loginUser(loginRequest)

        call?.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                if (response.isSuccessful) {
                    // Simpan sesi login di SharedPreferences setelah login berhasil
                    saveLoginSession()
                    callback.invoke(Result.Success(true))
                } else {
                    callback.invoke(Result.Error("Login failed: ${response.code()}"))
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                callback.invoke(Result.Error("Network error: ${t.message}"))
            }
        })
    }

    private fun saveLoginSession() {
        // Menggunakan SharedPreferences untuk menyimpan status login
        sharedPreferences.edit().putBoolean(LOGIN_STATUS_KEY, true).apply()
    }
}

