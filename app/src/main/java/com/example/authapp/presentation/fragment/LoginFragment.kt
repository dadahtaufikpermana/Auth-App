package com.example.authapp.presentation.fragment

import LoginViewModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.authapp.R
import com.example.authapp.data.Repository.LoginRepositoryImpl
import com.example.authapp.utils.SnackbarUtils
import com.example.authapp.utils.Result

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        emailEditText = view.findViewById(R.id.emailEditText)
        passwordEditText = view.findViewById(R.id.passwordEditText)
        loginButton = view.findViewById(R.id.loginButton)

        //  requireContext() untuk mendapatkan konteks Fragment
        val loginRepository = LoginRepositoryImpl(requireContext())
        loginViewModel = LoginViewModel(loginRepository)

        loginButton.setOnClickListener {
            performLogin()
        }
        passwordEditText.inputType =
            android.text.InputType.TYPE_CLASS_TEXT or android.text.InputType.TYPE_TEXT_VARIATION_PASSWORD
    }

    private fun performLogin() {
        val email: String = emailEditText.text.toString()
        val password: String = passwordEditText.text.toString()

        loginViewModel.loginUser(email, password) { result ->
            if (result is Result.Success) {
                val isSuccess = result.data
                if (isSuccess) {
                    SnackbarUtils.showSuccessSnackbar(requireView(), "Login success")
                } else {
                    SnackbarUtils.showErrorSnackbar(requireView(), "Login failed")
                }
            } else if (result is Result.Error) {
                SnackbarUtils.showErrorSnackbar(requireView(), "Error: ${result.message}")
            }
        }
    }


}

