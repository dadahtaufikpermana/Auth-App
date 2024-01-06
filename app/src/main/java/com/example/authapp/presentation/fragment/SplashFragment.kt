package com.example.authapp.presentation.fragment

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.authapp.R
import com.example.authapp.presentation.viewModel.SplashViewModel
import com.google.android.material.snackbar.Snackbar

class SplashFragment : Fragment() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val progressBar = view.findViewById<ProgressBar>(R.id.loadingProgressBar)
        progressBar.visibility = View.VISIBLE

        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        // Pengecekan koneksi internet
        if (isNetworkAvailable()) {
            viewModel.handleSplashScreen {
                findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
            }
        } else {
            showSnackbar("No internet access, please check")
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            requireContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    private fun showSnackbar(message: String) {
        val rootView: View = requireActivity().findViewById(android.R.id.content)
        val snackbar = Snackbar.make(rootView, message, Snackbar.LENGTH_LONG)
        snackbar.setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.black))
        snackbar.show()
    }
}
