package com.example.authapp.presentation.viewModel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {
    fun handleSplashScreen(navigateToNextScreen: () -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToNextScreen.invoke()
        }, 3000)
    }
}